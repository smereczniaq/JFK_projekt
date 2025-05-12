package com.pyplusplus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class LLVMActions extends PyPlusPlusBaseListener {
        class LoopContext {
        String iteratorName;
        String iterableName;
        String elementType;
        String llvmType;
        String sizeVar;
        String loopIdx;
        String loopCondLabel;
        String loopBodyLabel;
        String loopEndLabel;
        int listSize;
    }

    private String currentFunction = null;
    private final Map<String, StringBuilder> functionBodies = new HashMap<>();
    private final Map<String, List<String>> functionParams = new HashMap<>();
    private final Map<String, String> functionReturnTypes = new HashMap<>();
    private final Map<String, String> localAllocas = new HashMap<>();


    private final Stack<LoopContext> loopStack = new Stack<>();
    private final LLVMGenerator generator = new LLVMGenerator();
    private final ParseTreeProperty<String> values = new ParseTreeProperty<>();
    Map<String, String> symbolTable = new HashMap<>();

    private void debug(String msg) {
        System.err.println("[DEBUG] " + msg);
    }

    private void addInstruction(String instruction) {
        if (currentFunction == null) {
            generator.addMainInstruction(instruction);
        } else {
            functionBodies.get(currentFunction).append("  ").append(instruction).append("\n");
        }
    }
    

    @Override
    public void exitVariable_instantiation(PyPlusPlusParser.Variable_instantiationContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
    
        if (currentFunction != null) {
            // wewnątrz funkcji: sprawdzaj tylko zmienne lokalne
            if (localAllocas.containsKey(varName)) {
                throw new RuntimeException("Błąd semantyczny: zmienna lokalna '" + varName + "' została już zadeklarowana.");
            }
        } else {
            // w mainie: sprawdzaj tylko zmienne globalne
            if (symbolTable.containsKey(varName)) {
                throw new RuntimeException("Błąd semantyczny: zmienna globalna '" + varName + "' została już zadeklarowana.");
            }
        }
        
    
        String valueReg = null;
        String type = null;
    
        if (ctx.expression() != null) {
            ParseTreeWalker.DEFAULT.walk(this, ctx.expression());
            valueReg = values.get(ctx.expression());
            type = symbolTable.get(valueReg);
        }
    
        if (currentFunction != null) {
            // Lokalne zmienne – potrzebujemy alloca + store
            String alloca = generator.nextRegister();
            addInstruction(alloca + " = alloca i32"); // domyślnie int, potem nadpisz
            localAllocas.put(varName, alloca);
    
            if ("double".equals(type)) {
                addInstruction(alloca + " = alloca double");
                addInstruction("store double " + valueReg + ", double* " + alloca);
                symbolTable.put(varName, "double");
            } else if ("string".equals(type)) {
                addInstruction(alloca + " = alloca i8*");
                addInstruction("store i8* " + valueReg + ", i8** " + alloca);
                symbolTable.put(varName, "string");
            } else {
                addInstruction("store i32 " + valueReg + ", i32* " + alloca);
                symbolTable.put(varName, "int");
            }
    
        } else {
            // Zmienna globalna
            if ("double".equals(type)) {
                symbolTable.put(varName, "double");
                generator.declareDoubleVariable(varName);
                addInstruction("store double " + valueReg + ", double* @" + varName);
            } else if ("string".equals(type)) {
                symbolTable.put(varName, "string");
                generator.declareStringPointerVariable(varName);
                addInstruction("store i8* " + valueReg + ", i8** @" + varName);
            } else {
                symbolTable.put(varName, "int");
                generator.declareIntegerVariable(varName);
                addInstruction("store i32 " + valueReg + ", i32* @" + varName);
            }
        }
    }
    

    @Override
    public void exitList_declaration(PyPlusPlusParser.List_declarationContext ctx) {
        String listName = ctx.IDENTIFIER().getText();
        int size = ctx.literal_list().expression().size();
    
        PyPlusPlusParser.ExpressionContext firstExprCtx = ctx.literal_list().expression(0);
        ParseTreeWalker.DEFAULT.walk(this, firstExprCtx);
        String firstReg = values.get(firstExprCtx);
        String firstType = symbolTable.get(firstReg);
    
        String listType;
        if ("double".equals(firstType)) {
            listType = "double";
        } else if ("int".equals(firstType)) {
            listType = "int";
        } else if ("string".equals(firstType)) {
            listType = "string";
        } else {
            throw new RuntimeException("Nieobsługiwany typ elementów listy.");
        }
    
        symbolTable.put(listName, "list_" + listType);
    
        // Przygotuj elementy
        List<String> elements = new ArrayList<>();
        for (var exprCtx : ctx.literal_list().expression()) {
            String literalValue = exprCtx.getText();
            if (listType.equals("int") && literalValue.matches("\\d+")) {
                elements.add("i32 " + literalValue);
            } else if (listType.equals("double") && literalValue.matches("\\d+(\\.\\d+)?")) {
                if (!literalValue.contains(".")) literalValue += ".0";
                elements.add("double " + literalValue);
            } else if (listType.equals("string") && literalValue.startsWith("\"") && literalValue.endsWith("\"")) {
                String strReg = generator.nextGlobalString();
                String content = literalValue.substring(1, literalValue.length() - 1);
                int len = content.length() + 1;
                String llvmStr = content.replace("\\n", "\\0A")
                                        .replace("\\t", "\\09")
                                        .replace("\"", "\\22") + "\\00";
                generator.declareStringConstant(strReg, len, llvmStr);
                elements.add("i8* getelementptr inbounds ([" + len + " x i8], [" + len + " x i8]* " + strReg + ", i32 0, i32 0)");
            } else {
                throw new RuntimeException("Lista musi być jednorodna typu: " + listType);
            }
        }
    
        generator.declareList(listName, listType, size, elements);
    
        // WAŻNE: Zapamiętaj rozmiar listy w symbolTable!
        symbolTable.put(listName + "_size_value", String.valueOf(size));
    }
      

    @Override
    public void exitList_access(PyPlusPlusParser.List_accessContext ctx) {
        String listName = ctx.IDENTIFIER().getText();
        ParseTreeWalker.DEFAULT.walk(this, ctx.expression());
        String indexReg = values.get(ctx.expression());
    
        if (!symbolTable.containsKey(listName) || !symbolTable.get(listName).startsWith("list_")) {
            throw new RuntimeException("Błąd: '" + listName + "' nie jest zadeklarowaną listą.");
        }
    
        String listType = symbolTable.get(listName).substring(5);
        String llvmType;
        if ("double".equals(listType))
            llvmType = "double";
        else if ("int".equals(listType))
            llvmType = "i32";
        else
            llvmType = "i8*";
    
        int size = 0; // w praktyce zapisz realny rozmiar w symbolTable podczas deklaracji
    
        String elemPtr = generator.nextRegister();
        String elemVal = generator.nextRegister();
        addInstruction(elemPtr + " = getelementptr [" + size + " x " + llvmType + "], [" + size + " x " + llvmType + "]* @" + listName + ", i32 0, i32 " + indexReg);
        addInstruction(elemVal + " = load " + llvmType + ", " + llvmType + "* " + elemPtr);
    
        values.put(ctx, elemVal);
        symbolTable.put(elemVal, listType);
    }

    @Override
    public void exitValue_assignment(PyPlusPlusParser.Value_assignmentContext ctx) {
        String lhsId = ctx.expression(0).getText();
        String rhs = values.get(ctx.expression(1));
    
        if (!symbolTable.containsKey(lhsId)) {
            throw new RuntimeException("Błąd semantyczny: zmienna '" + lhsId + "' nie została zadeklarowana.");
        }
    
        if (rhs != null) {
            String type = symbolTable.get(lhsId);
            String ptr;
    
            if (localAllocas.containsKey(lhsId)) {
                ptr = localAllocas.get(lhsId); // lokalna zmienna
            } else {
                ptr = "@" + lhsId; // globalna zmienna
            }
    
            switch (type) {
                case "double":
                    addInstruction("store double " + rhs + ", double* " + ptr);
                    break;
                case "string":
                    addInstruction("store i8* " + rhs + ", i8** " + ptr);
                    break;
                default:
                    addInstruction("store i32 " + rhs + ", i32* " + ptr);
            }
        } else {
            debug("Brak RHS dla przypisania do: " + lhsId);
        }
    }
    

    @Override
    public void exitExpression(PyPlusPlusParser.ExpressionContext ctx) {
        values.put(ctx, values.get(ctx.logicalOrExpr()));
    }


    @Override
    public void exitLogicalOrExpr(PyPlusPlusParser.LogicalOrExprContext ctx) {
        int count = ctx.xorExpr().size();
    
        if (count == 1) {
            values.put(ctx, values.get(ctx.xorExpr(0)));
            return;
        }
    
        String result = values.get(ctx.xorExpr(0));
        for (int i = 1; i < count; i++) {
            String right = values.get(ctx.xorExpr(i));
    
            if (result == null || right == null) {
                debug("Brakuje operandów dla ||");
                return;
            }
    
            // Sprawdź typy
            String leftType = symbolTable.get(result);
            String rightType = symbolTable.get(right);
    
            boolean leftIsDouble = "double".equals(leftType);
            boolean rightIsDouble = "double".equals(rightType);
    
            String leftCond = generator.nextRegister();
            if (leftIsDouble) {
                addInstruction(leftCond + " = fcmp une double " + result + ", 0.0");
            } else {
                addInstruction(leftCond + " = icmp ne i32 " + result + ", 0");
            }
    
            String rightCond = generator.nextRegister();
            if (rightIsDouble) {
                addInstruction(rightCond + " = fcmp une double " + right + ", 0.0");
            } else {
                addInstruction(rightCond + " = icmp ne i32 " + right + ", 0");
            }
    
            // or i1
            String orResult = generator.nextRegister();
            addInstruction(orResult + " = or i1 " + leftCond + ", " + rightCond);
    
            // Rozszerz do i32
            result = generator.nextRegister();
            addInstruction(result + " = zext i1 " + orResult + " to i32");
    
            symbolTable.put(result, "int");
        }
    
        values.put(ctx, result);
    }    
    

    @Override
    public void exitXorExpr(PyPlusPlusParser.XorExprContext ctx) {
        int count = ctx.logicalAndExpr().size();
    
        if (count == 1) {
            values.put(ctx, values.get(ctx.logicalAndExpr(0)));
            return;
        }
    
        String result = values.get(ctx.logicalAndExpr(0));
    
        for (int i = 1; i < count; i++) {
            String right = values.get(ctx.logicalAndExpr(i));
    
            if (result == null || right == null) {
                debug("Brakuje operandów dla #");
                return;
            }
    
            String leftType = symbolTable.get(result);
            String rightType = symbolTable.get(right);
    
            boolean leftIsDouble = "double".equals(leftType);
            boolean rightIsDouble = "double".equals(rightType);
    
            // Konwersja operandów do boola
            String leftCond = generator.nextRegister();
            if (leftIsDouble) {
                addInstruction(leftCond + " = fcmp une double " + result + ", 0.0");
            } else {
                addInstruction(leftCond + " = icmp ne i32 " + result + ", 0");
            }
    
            String rightCond = generator.nextRegister();
            if (rightIsDouble) {
                addInstruction(rightCond + " = fcmp une double " + right + ", 0.0");
            } else {
                addInstruction(rightCond + " = icmp ne i32 " + right + ", 0");
            }
    
            // XOR logiczne
            String xorResult = generator.nextRegister();
            addInstruction(xorResult + " = xor i1 " + leftCond + ", " + rightCond);
    
            // Rozszerzenie do i32 — gotowe na kolejną iterację lub końcowy wynik
            result = generator.nextRegister();
            addInstruction(result + " = zext i1 " + xorResult + " to i32");
    
            symbolTable.put(result, "int");
        }
    
        values.put(ctx, result);
    }    
    

    @Override
    public void exitLogicalAndExpr(PyPlusPlusParser.LogicalAndExprContext ctx) {
        int count = ctx.comparisonExpr().size();
    
        if (count == 1) {
            values.put(ctx, values.get(ctx.comparisonExpr(0)));
            return;
        }
    
        String result = values.get(ctx.comparisonExpr(0));
    
        for (int i = 1; i < count; i++) {
            String right = values.get(ctx.comparisonExpr(i));
    
            if (result == null || right == null) {
                debug("Brakuje operandów dla &&");
                return;
            }
    
            String leftType = symbolTable.get(result);
            String rightType = symbolTable.get(right);
    
            boolean leftIsDouble = "double".equals(leftType);
            boolean rightIsDouble = "double".equals(rightType);
    
            // Porównanie operandów do zera (czy są "true")
            String leftCond = generator.nextRegister();
            if (leftIsDouble) {
                addInstruction(leftCond + " = fcmp une double " + result + ", 0.0");
            } else {
                addInstruction(leftCond + " = icmp ne i32 " + result + ", 0");
            }
    
            String rightCond = generator.nextRegister();
            if (rightIsDouble) {
                addInstruction(rightCond + " = fcmp une double " + right + ", 0.0");
            } else {
                addInstruction(rightCond + " = icmp ne i32 " + right + ", 0");
            }
    
            // AND logiczne
            String andResult = generator.nextRegister();
            addInstruction(andResult + " = and i1 " + leftCond + ", " + rightCond);
    
            // Rozszerzenie do i32 — gotowe na kolejną iterację lub użycie końcowe
            result = generator.nextRegister();
            addInstruction(result + " = zext i1 " + andResult + " to i32");
    
            symbolTable.put(result, "int");
        }
    
        values.put(ctx, result);
    }    
    

    @Override
    public void exitComparisonExpr(PyPlusPlusParser.ComparisonExprContext ctx) {
        int count = ctx.addExpr().size();
    
        if (count == 1) {
            values.put(ctx, values.get(ctx.addExpr(0)));
            return;
        }
    
        if (ctx.addExpr().size() > 2) {
            debug("Więcej niż jedno porównanie w jednym wyrażeniu – tylko pierwszy operator zostanie użyty");
        }
    
        String left = values.get(ctx.addExpr(0));
        String right = values.get(ctx.addExpr(1));
        String operator = ctx.getChild(1).getText(); // np. ==, !=, <, <=, >, >=
    
        if (left == null || right == null) {
            debug("Brakuje operandów w comparisonExpr");
            return;
        }
    
        String leftType = symbolTable.get(left);
        String rightType = symbolTable.get(right);
        boolean isDouble = "double".equals(leftType) || "double".equals(rightType);
    
        // Rzutowanie int → double
        if ("int".equals(leftType) && isDouble) {
            String casted = generator.nextRegister();
            addInstruction(casted + " = sitofp i32 " + left + " to double");
            left = casted;
            symbolTable.put(left, "double");
        }
    
        if ("int".equals(rightType) && isDouble) {
            String casted = generator.nextRegister();
            addInstruction(casted + " = sitofp i32 " + right + " to double");
            right = casted;
            symbolTable.put(right, "double");
        }
    
        // LLVM operator i typ
        String llvmOp;
        String cmpInstr = isDouble ? "fcmp" : "icmp";
        String type = isDouble ? "double" : "i32";
    
        switch (operator) {
            case "==": llvmOp = isDouble ? "oeq" : "eq"; break;
            case "!=": llvmOp = isDouble ? "one" : "ne"; break;
            case "<":  llvmOp = isDouble ? "olt" : "slt"; break;
            case "<=": llvmOp = isDouble ? "ole" : "sle"; break;
            case ">":  llvmOp = isDouble ? "ogt" : "sgt"; break;
            case ">=": llvmOp = isDouble ? "oge" : "sge"; break;
            default:
                debug("Nieznany operator porównania: " + operator);
                return;
        }
    
        // Generowanie porównania
        String result = generator.nextRegister();
        addInstruction(result + " = " + cmpInstr + " " + llvmOp + " " + type + " " + left + ", " + right);
    
        // Rozszerzenie do i32
        String extended = generator.nextRegister();
        addInstruction(extended + " = zext i1 " + result + " to i32");
    
        values.put(ctx, extended);
        symbolTable.put(extended, "int"); // wynik porównania to zawsze int (bool jako 0/1)
    }    
    

    @Override
    public void exitAddExpr(PyPlusPlusParser.AddExprContext ctx) {
        int count = ctx.mulExpr().size();
    
        if (count == 1) {
            String val = values.get(ctx.mulExpr(0));
            values.put(ctx, val);
            return;
        }
    
        String left = values.get(ctx.mulExpr(0));
        if (left == null) {
            debug("Brakuje lewego operandu w addExpr");
            return;
        }
    
        String result = left;
    
        for (int i = 1; i < count; i++) {
            String right = values.get(ctx.mulExpr(i));
            String operator = ctx.getChild(2 * i - 1).getText(); // '+' lub '-'
    
            if (right == null) {
                debug("Brakuje prawego operandu w addExpr");
                return;
            }
    
            // Ustal typy operandów
            String leftType = symbolTable.get(result);
            String rightType = symbolTable.get(right);
            boolean isDouble = "double".equals(leftType) || "double".equals(rightType);
    
            // Rzutowanie int → double
            if ("int".equals(leftType) && isDouble) {
                String casted = generator.nextRegister();
                addInstruction(casted + " = sitofp i32 " + result + " to double");
                result = casted;
                symbolTable.put(result, "double");
            }
    
            if ("int".equals(rightType) && isDouble) {
                String casted = generator.nextRegister();
                addInstruction(casted + " = sitofp i32 " + right + " to double");
                right = casted;
                symbolTable.put(right, "double");
            }
    
            String temp = generator.nextRegister();
    
            switch (operator) {
                case "+" -> addInstruction(temp + " = " + (isDouble ? "fadd double " : "add i32 ") + result + ", " + right);
                case "-" -> addInstruction(temp + " = " + (isDouble ? "fsub double " : "sub i32 ") + result + ", " + right);
                default -> {
                    debug("Nieznany operator w addExpr: " + operator);
                    return;
                }
            }
    
            result = temp;
            symbolTable.put(result, isDouble ? "double" : "int");
        }
    
        values.put(ctx, result);
    }
    
    

    @Override
    public void exitMulExpr(PyPlusPlusParser.MulExprContext ctx) {
        int count = ctx.powExpr().size();
    
        if (count == 1) {
            String val = values.get(ctx.powExpr(0));
            values.put(ctx, val);
            return;
        }
    
        String left = values.get(ctx.powExpr(0));
        if (left == null) {
            debug("Brakuje lewego operandu w mulExpr");
            return;
        }
    
        String result = left;
    
        for (int i = 1; i < count; i++) {
            String right = values.get(ctx.powExpr(i));
            String operator = ctx.getChild(2 * i - 1).getText(); // '*' lub '/'
    
            if (right == null) {
                debug("Brakuje prawego operandu w mulExpr");
                return;
            }
    
            // Typy operandów
            String leftType = symbolTable.get(result);
            String rightType = symbolTable.get(right);
            boolean isDouble = "double".equals(leftType) || "double".equals(rightType);
    
            // Rzutowanie int → double
            if ("int".equals(leftType) && isDouble) {
                String casted = generator.nextRegister();
                addInstruction(casted + " = sitofp i32 " + result + " to double");
                result = casted;
                symbolTable.put(result, "double");
            }
    
            if ("int".equals(rightType) && isDouble) {
                String casted = generator.nextRegister();
                addInstruction(casted + " = sitofp i32 " + right + " to double");
                right = casted;
                symbolTable.put(right, "double");
            }
    
            String temp = generator.nextRegister();
    
            switch (operator) {
                case "*" -> addInstruction(temp + " = " + (isDouble ? "fmul double " : "mul i32 ") + result + ", " + right);
                case "/" -> addInstruction(temp + " = " + (isDouble ? "fdiv double " : "sdiv i32 ") + result + ", " + right);
                default -> {
                    debug("Nieznany operator w mulExpr: " + operator);
                    return;
                }
            }
    
            result = temp;
            symbolTable.put(result, isDouble ? "double" : "int");
        }
    
        values.put(ctx, result);
    }    
    

    @Override
    public void exitPowExpr(PyPlusPlusParser.PowExprContext ctx) {
        String base = values.get(ctx.unaryExpr());
        if (base == null) {
            debug("Brakuje podstawy w powExpr");
            return;
        }
    
        if (ctx.powExpr() == null) {
            // tylko jedna wartość — przekazujemy w górę bez operacji
            values.put(ctx, base);
            return;
        }
    
        String exp = values.get(ctx.powExpr());
        if (exp == null) {
            debug("Brakuje wykładnika w powExpr");
            return;
        }
    
        // Ustal typy
        String baseType = symbolTable.get(base);
        String expType = symbolTable.get(exp);
        boolean isDouble = "double".equals(baseType) || "double".equals(expType);
    
        // Rzutowanie int → double
        if ("int".equals(baseType) && isDouble) {
            String casted = generator.nextRegister();
            addInstruction(casted + " = sitofp i32 " + base + " to double");
            base = casted;
            symbolTable.put(base, "double");
        }
    
        if ("int".equals(expType) && isDouble) {
            String casted = generator.nextRegister();
            addInstruction(casted + " = sitofp i32 " + exp + " to double");
            exp = casted;
            symbolTable.put(exp, "double");
        }
    
        String result = generator.nextRegister();
    
        if (isDouble) {
            addInstruction(result + " = call double @llvm.pow.f64(double " + base + ", double " + exp + ")");
            symbolTable.put(result, "double");
        } else {
            addInstruction(result + " = call i32 @powi(i32 " + base + ", i32 " + exp + ")");
            symbolTable.put(result, "int");
        }
    
        values.put(ctx, result);
    }
    

    @Override
    public void exitUnaryExpr(PyPlusPlusParser.UnaryExprContext ctx) {
        if (ctx.getChildCount() == 2) {
            String op = ctx.getChild(0).getText();
            String operand = values.get(ctx.unaryExpr());
    
            if (operand == null) {
                debug("Operand unaryExpr nie ma wartości");
                return;
            }
    
            String type = symbolTable.get(operand);
            String result = generator.nextRegister();
    
            switch (op) {
                case "!":
                    boolean isDouble = "double".equals(type);
                    String condition = generator.nextRegister();
                    if (isDouble) {
                        addInstruction(condition + " = fcmp une double " + operand + ", 0.0");
                    } else {
                        addInstruction(condition + " = icmp ne i32 " + operand + ", 0");
                    }
    
                    String notResult = generator.nextRegister();
                    addInstruction(notResult + " = xor i1 " + condition + ", true");
    
                    addInstruction(result + " = zext i1 " + notResult + " to i32");
                    symbolTable.put(result, "int");
                    break;
    
                case "-":
                    if ("double".equals(type)) {
                        addInstruction(result + " = fsub double 0.0, " + operand);
                        symbolTable.put(result, "double");
                    } else {
                        addInstruction(result + " = sub i32 0, " + operand);
                        symbolTable.put(result, "int");
                    }
                    break;
    
                default:
                    debug("Nieznany operator unarny: " + op);
                    return;
            }
    
            values.put(ctx, result);
        }
    
        else if (ctx.primary() != null) {
            String val = values.get(ctx.primary());
            values.put(ctx, val);
        }
    
        else {
            debug("Nieznana forma unaryExpr: " + ctx.getText());
        }
    }    
    
    
    // @Override
    // public void exitParensExpr(PyPlusPlusParser.ParensExprContext ctx) {
    //     // Po prostu przekaż wartość z wnętrza nawiasów dalej
    //     String inner = values.get(ctx.expression());
    //     values.put(ctx, inner);
    // }

    // @Override
    // public void exitLiteralExpr(PyPlusPlusParser.LiteralExprContext ctx) {
    //     values.put(ctx, values.get(ctx.literal()));
    // }
    @Override
    public void exitLiteral(PyPlusPlusParser.LiteralContext ctx) {
        String val = ctx.getText();
        String reg = generator.nextRegister();
    
        if (val.startsWith("\"") && val.endsWith("\"")) {
            String strContent = val.substring(1, val.length() - 1);  // Remove quotes
            String strLabel = generator.nextGlobalString(); // like @.str1, @.str2, etc.
    
            int size = strContent.length() + 1; // +1 for \0
            String llvmStr = strContent.replace("\\n", "\\0A")
                                       .replace("\\t", "\\09")
                                       .replace("\"", "\\22") + "\\00";
    
            generator.declareStringConstant(strLabel, size, llvmStr);
            addInstruction(reg + " = getelementptr inbounds [" + size + " x i8], [" + size + " x i8]* " + strLabel + ", i32 0, i32 0");
    
            values.put(ctx, reg);
            symbolTable.put(reg, "string");  // more readable name instead of i8*
        }
        else if (val.contains(".")) {
            addInstruction(reg + " = fadd double 0.0, " + val);
            values.put(ctx, reg);
            symbolTable.put(reg, "double");
        } 
        else {
            addInstruction(reg + " = add i32 0, " + val);
            values.put(ctx, reg);
            symbolTable.put(reg, "int");
        }
    
        values.put(ctx, reg);
    }

    @Override
    public void exitPrimary(PyPlusPlusParser.PrimaryContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            String varName = ctx.IDENTIFIER().getText();
    
            if (!symbolTable.containsKey(varName)) {
                throw new RuntimeException("Błąd semantyczny: zmienna '" + varName + "' nie została zadeklarowana.");
            }
    
            String varType = symbolTable.get(varName);
            String reg = generator.nextRegister();
            String ptr = localAllocas.containsKey(varName) ? localAllocas.get(varName) : "@" + varName;
    
            if ("double".equals(varType)) {
                addInstruction(reg + " = load double, double* " + ptr);
                symbolTable.put(reg, "double");
            } else if ("string".equals(varType)) {
                addInstruction(reg + " = load i8*, i8** " + ptr);
                symbolTable.put(reg, "string");
            } else {
                addInstruction(reg + " = load i32, i32* " + ptr);
                symbolTable.put(reg, "int");
            }
    
            values.put(ctx, reg);
        }
    
        else if (ctx.literal() != null) {
            values.put(ctx, values.get(ctx.literal()));
        }
    
        else if (ctx.function_call() != null) {
            String functionName = ctx.function_call().IDENTIFIER().getText();
    
            if (functionName.equals("print")) {
                if (ctx.function_call().expression(0) != null) {
                    String argValue = values.get(ctx.function_call().expression(0));
                    if (argValue != null) {
                        String type = symbolTable.get(argValue);
                        String dummy = generator.nextRegister();
    
                        if ("double".equals(type)) {
                            addInstruction(dummy + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @format_double, i32 0, i32 0), double " + argValue + ")");
                        } else if ("string".equals(type)) {
                            addInstruction(dummy + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @format_string, i32 0, i32 0), i8* " + argValue + ")");
                        } else {
                            addInstruction(dummy + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @format, i32 0, i32 0), i32 " + argValue + ")");
                        }
                    } else {
                        debug("Brak wartości do wypisania w print()");
                    }
                }
                values.put(ctx, "0");
            }
    
            else if (functionName.equals("read")) {
                String allocaReg = generator.nextRegister();
                String dummy = generator.nextRegister();
                String loadReg = generator.nextRegister();
    
                addInstruction(allocaReg + " = alloca double");
                addInstruction(dummy + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @read_format_double, i32 0, i32 0), double* " + allocaReg + ")");
                addInstruction(loadReg + " = load double, double* " + allocaReg);
                symbolTable.put(loadReg, "double");
    
                values.put(ctx, loadReg);
            }
    
            else {
                List<String> args = new ArrayList<>();
                for (var expr : ctx.function_call().expression()) {
                    ParseTreeWalker.DEFAULT.walk(this, expr);
                    String reg = values.get(expr);
                    args.add(reg);
                }
    
                String callReg = generator.nextRegister();
                StringBuilder call = new StringBuilder();
                String returnType = functionReturnTypes.getOrDefault(functionName, "int");
    
                String llvmRetType = "i32";
                if ("double".equals(returnType)) llvmRetType = "double";
                else if ("string".equals(returnType)) llvmRetType = "i8*";
    
                call.append(callReg).append(" = call ").append(llvmRetType).append(" @").append(functionName).append("(");
                for (int i = 0; i < args.size(); i++) {
                    call.append("i32 ").append(args.get(i)); // domyślnie
                    if (i < args.size() - 1) call.append(", ");
                }
                call.append(")");
                addInstruction(call.toString());
    
                values.put(ctx, callReg);
                symbolTable.put(callReg, returnType);
            }
        }
    
        else if (ctx.list_access() != null) {
            values.put(ctx, values.get(ctx.list_access()));
        }
    
        else if (ctx.expression() != null) {
            values.put(ctx, values.get(ctx.expression())); // nawiasy
        }
    
        else {
            debug("Nieznany przypadek w primary: " + ctx.getText());
        }
    }
    

    @Override
    public void exitReturn_statement(PyPlusPlusParser.Return_statementContext ctx) {
        if (ctx.expression() != null) {
            String val = values.get(ctx.expression());
            if (val != null) {
                String type = symbolTable.get(val);
                if ("double".equals(type)) {
                    String casted = generator.nextRegister();
                    addInstruction(casted + " = fptosi double " + val + " to i32");
                    addInstruction("ret i32 " + casted);
                } else {
                    addInstruction("ret i32 " + val);
                }
            } else {
                debug("Brak wartości w return");
                addInstruction("ret i32 0");
            }
        } else {
            addInstruction("ret i32 0");
        }
    }

    @Override
    public void exitWhile_loop(PyPlusPlusParser.While_loopContext ctx) {
        String condLabel = "while.cond" + generator.nextLabelId();
        String bodyLabel = "while.body" + generator.nextLabelId();
        String endLabel = "while.end" + generator.nextLabelId();
    
        // Skok do warunku
        addInstruction("br label %" + condLabel);
    
        // LABEL: while.cond
        addInstruction(condLabel + ":");
    
        // Oblicz warunek — musimy najpierw przetworzyć jego poddrzewo!
        ParseTreeWalker.DEFAULT.walk(this, ctx.expression());
    
        String condReg = values.get(ctx.expression());
        if (condReg == null) {
            debug("Brak warunku w pętli while");
            condReg = "0";
        }
    
        String condType = symbolTable.get(condReg);
        String cmpReg;
    
        if ("double".equals(condType)) {
            String cond_i1 = generator.nextRegister();
            addInstruction(cond_i1 + " = fcmp une double " + condReg + ", 0.0");
            cmpReg = cond_i1;
        } else {
            String cond_i1 = generator.nextRegister();
            addInstruction(cond_i1 + " = icmp ne i32 " + condReg + ", 0");
            cmpReg = cond_i1;
        }
    
        addInstruction("br i1 " + cmpReg + ", label %" + bodyLabel + ", label %" + endLabel);
    
        // LABEL: while.body
        addInstruction(bodyLabel + ":");
    
        for (PyPlusPlusParser.StatementContext stmt : ctx.statement()) {
            ParseTreeWalker.DEFAULT.walk(this, stmt);
        }
    
        // Po ciele pętli, wracamy do sprawdzenia warunku
        addInstruction("br label %" + condLabel);
    
        // LABEL: while.end
        addInstruction(endLabel + ":");
    }

    @Override
    public void enterFor_loop(PyPlusPlusParser.For_loopContext ctx) {
        LoopContext loop = new LoopContext();
    
        loop.iteratorName = ctx.IDENTIFIER(0).getText();
        loop.iterableName = ctx.getChild(3).getText();
    
        if (!symbolTable.containsKey(loop.iterableName) || !symbolTable.get(loop.iterableName).startsWith("list_")) {
            throw new RuntimeException("Błąd: '" + loop.iterableName + "' nie jest zadeklarowaną listą.");
        }
    
        loop.elementType = symbolTable.get(loop.iterableName).substring(5);
    
        switch (loop.elementType) {
            case "double":
                loop.llvmType = "double";
                generator.declareDoubleVariable(loop.iteratorName);
                break;
            case "int":
                loop.llvmType = "i32";
                generator.declareIntegerVariable(loop.iteratorName);
                break;
            case "string":
                loop.llvmType = "i8*";
                generator.declareStringPointerVariable(loop.iteratorName);
                break;
            default:
                throw new RuntimeException("Nieobsługiwany typ elementu: " + loop.elementType);
        }
    
        symbolTable.put(loop.iteratorName, loop.elementType);
    
        // Ładowanie rozmiaru listy
        loop.sizeVar = generator.nextRegister();
        addInstruction(loop.sizeVar + " = load i32, i32* @" + loop.iterableName + "_size");
    
        // Inicjalizacja indeksu na stosie
        loop.loopIdx = generator.nextRegister();
        addInstruction(loop.loopIdx + " = alloca i32");
        addInstruction("store i32 0, i32* " + loop.loopIdx);
    
        // Utworzenie labeli
        loop.loopCondLabel = "for.cond" + generator.nextLabelId();
        loop.loopBodyLabel = "for.body" + generator.nextLabelId();
        loop.loopEndLabel = "for.end" + generator.nextLabelId();
    
        // Skok do warunku
        addInstruction("br label %" + loop.loopCondLabel);
    
        // Warunek pętli
        addInstruction(loop.loopCondLabel + ":");
        String currentIdx = generator.nextRegister();
        addInstruction(currentIdx + " = load i32, i32* " + loop.loopIdx);
        String cmp = generator.nextRegister();
        addInstruction(cmp + " = icmp slt i32 " + currentIdx + ", " + loop.sizeVar);
        addInstruction("br i1 " + cmp + ", label %" + loop.loopBodyLabel + ", label %" + loop.loopEndLabel);
    
        // Ciało pętli (załaduj iterator przed ciałem!)
        addInstruction(loop.loopBodyLabel + ":");
    
        String elemPtr = generator.nextRegister();
        int listSize = Integer.parseInt(symbolTable.get(loop.iterableName + "_size_value"));
        loop.listSize = listSize;
    
        addInstruction(elemPtr + " = getelementptr [" + listSize + " x " + loop.llvmType + "], [" + listSize + " x " + loop.llvmType + "]* @" + loop.iterableName + ", i32 0, i32 " + currentIdx);
    
        String elemVal = generator.nextRegister();
        addInstruction(elemVal + " = load " + loop.llvmType + ", " + loop.llvmType + "* " + elemPtr);
    
        addInstruction("store " + loop.llvmType + " " + elemVal + ", " + loop.llvmType + "* @" + loop.iteratorName);
    
        loopStack.push(loop);
    }
    

    @Override
    public void exitFor_loop(PyPlusPlusParser.For_loopContext ctx) {
        LoopContext loop = loopStack.pop();
    
        // Inkrementacja indeksu po ciele pętli
        String currentIdx = generator.nextRegister();
        addInstruction(currentIdx + " = load i32, i32* " + loop.loopIdx);
        String nextIdx = generator.nextRegister();
        addInstruction(nextIdx + " = add i32 " + currentIdx + ", 1");
        addInstruction("store i32 " + nextIdx + ", i32* " + loop.loopIdx);
    
        // Powrót do warunku
        addInstruction("br label %" + loop.loopCondLabel);
    
        // Label końcowy pętli
        addInstruction(loop.loopEndLabel + ":");
    
        symbolTable.remove(loop.iteratorName);
    }

    @Override
    public void enterFunction_definition(PyPlusPlusParser.Function_definitionContext ctx) {
        currentFunction = ctx.IDENTIFIER(0).getText();
    
        // Zainicjalizuj nowe ciało funkcji
        functionBodies.put(currentFunction, new StringBuilder());
        functionParams.put(currentFunction, new ArrayList<>());
        localAllocas.clear(); // ⬅️ WYCZYŚĆ allokacje lokalne na początku funkcji
    
        // Typ zwracany
        String returnType = "int";
        if (ctx.type() != null) {
            returnType = ctx.type().getText();
        }
        functionReturnTypes.put(currentFunction, returnType);
    
        // Parametry funkcji
        List<String> paramNames = new ArrayList<>();
        if (ctx.IDENTIFIER().size() > 1) {
            for (int i = 1; i < ctx.IDENTIFIER().size(); i++) {
                String paramName = ctx.IDENTIFIER(i).getText();
                paramNames.add(paramName);
            }
        }
        functionParams.get(currentFunction).addAll(paramNames);
    
        // LLVM parametry — alloca + store
        for (String name : paramNames) {
            String llvmReg = "%" + name;
            String alloca = generator.nextRegister();
            functionBodies.get(currentFunction).append("  ").append(alloca).append(" = alloca i32\n");
            functionBodies.get(currentFunction).append("  store i32 ").append(llvmReg).append(", i32* ").append(alloca).append("\n");
    
            symbolTable.put(name, "int");
            localAllocas.put(name, alloca); // ⬅️ ZAPAMIĘTAJ alloca dla lokalnego parametru
        }
    }    

    @Override
    public void exitFunction_definition(PyPlusPlusParser.Function_definitionContext ctx) {
        StringBuilder func = new StringBuilder();

        String llvmReturnType = "i32";
        String returnType = functionReturnTypes.get(currentFunction);
        if ("double".equals(returnType)) llvmReturnType = "double";
        else if ("string".equals(returnType)) llvmReturnType = "i8*";

        func.append("define ").append(llvmReturnType).append(" @")
            .append(currentFunction).append("(");

        List<String> paramList = functionParams.get(currentFunction);
        for (int i = 0; i < paramList.size(); i++) {
            String name = paramList.get(i);
            func.append("i32 %").append(name);  // domyślnie i32
            if (i < paramList.size() - 1) {
                func.append(", ");
            }
        }

        func.append(") {\nentry:\n");

        // Treść funkcji
        func.append(functionBodies.get(currentFunction).toString());

        // Jeżeli nie było return, domyślne zakończenie
        func.append("  ret ").append(llvmReturnType).append(" ");
        if ("double".equals(returnType)) func.append("0.0\n");
        else if ("string".equals(returnType)) func.append("null\n");
        else func.append("0\n");
        func.append("}\n");

        generator.appendFunctionDefinition(func.toString());

        currentFunction = null;
        localAllocas.clear();
    }

    @Override
    public void exitIf_statement(PyPlusPlusParser.If_statementContext ctx) {
        String labelId = generator.nextLabelId();
        String endLabel = "if.end" + labelId;

        List<String> condLabels = new ArrayList<>();
        List<String> bodyLabels = new ArrayList<>();

        // Główne if + wszystkie else-if
        int totalConds = 1 + ctx.expression().size() - 1;

        for (int i = 0; i < totalConds; i++) {
            condLabels.add("if.cond" + labelId + "." + i);
            bodyLabels.add("if.body" + labelId + "." + i);
        }

        String elseLabel = ctx.getChild(ctx.getChildCount() - 2).getText().equals("else") ?
            "if.else" + labelId : null;

        // Skok do pierwszego warunku
        addInstruction("br label %" + condLabels.get(0));

        // Główne if i else-if
        for (int i = 0; i < totalConds; i++) {
            addInstruction(condLabels.get(i) + ":");
            ParseTreeWalker.DEFAULT.walk(this, ctx.expression(i));

            String condReg = values.get(ctx.expression(i));
            String condType = symbolTable.get(condReg);
            String cmpReg;

            if ("double".equals(condType)) {
                cmpReg = generator.nextRegister();
                addInstruction(cmpReg + " = fcmp une double " + condReg + ", 0.0");
            } else {
                cmpReg = generator.nextRegister();
                addInstruction(cmpReg + " = icmp ne i32 " + condReg + ", 0");
            }

            String nextCondLabel = (i + 1 < totalConds)
                ? condLabels.get(i + 1)
                : (elseLabel != null ? elseLabel : endLabel);

            addInstruction("br i1 " + cmpReg + ", label %" + bodyLabels.get(i) + ", label %" + nextCondLabel);

            // Ciało warunku
            addInstruction(bodyLabels.get(i) + ":");
            ParseTreeWalker.DEFAULT.walk(this, ctx.statement(i));
            addInstruction("br label %" + endLabel);
        }

        // Else (jeśli istnieje)
        if (elseLabel != null) {
            addInstruction(elseLabel + ":");
            ParseTreeWalker.DEFAULT.walk(this, ctx.statement(ctx.statement().size() - 1));
            addInstruction("br label %" + endLabel);
        }

        // Zakończenie if
        addInstruction(endLabel + ":");
    }
    

    public String getLLVMCode() {
        return generator.generate();
    }
}

// CHECKPOINT;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;