package com.pyplusplus;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class LLVMActions extends PyPlusPlusBaseListener {
    private final LLVMGenerator generator = new LLVMGenerator();
    private final ParseTreeProperty<String> values = new ParseTreeProperty<>();
    Map<String, String> symbolTable = new HashMap<>();

    private void debug(String msg) {
        System.err.println("[DEBUG] " + msg);
    }

    @Override
    public void exitVariable_instantiation(PyPlusPlusParser.Variable_instantiationContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
    
        if (symbolTable.containsKey(varName)) {
            throw new RuntimeException("Błąd semantyczny: zmienna '" + varName + "' została już zadeklarowana.");
        }
    
        String valueReg = values.get(ctx.expression());
        String type = symbolTable.get(valueReg);
    
        if (ctx.expression() != null) {
            if (valueReg != null) {
                if ("double".equals(type)) {
                    symbolTable.put(varName, "double");
                    generator.declareDoubleVariable(varName);
                    generator.addMainInstruction("store double " + valueReg + ", double* @" + varName);
                } else if ("string".equals(type)) {
                    symbolTable.put(varName, "string");
                    generator.declareStringPointerVariable(varName);
                    generator.addMainInstruction("store i8* " + valueReg + ", i8** @" + varName);
                } else {
                    symbolTable.put(varName, "int");
                    generator.declareIntegerVariable(varName);
                    generator.addMainInstruction("store i32 " + valueReg + ", i32* @" + varName);
                }
            } else {
                debug("Brak wartości dla przypisania w 'var " + varName + "'");
            }
        }
    }
    
     

    @Override
    public void exitValue_assignment(PyPlusPlusParser.Value_assignmentContext ctx) {
        String lhsId = ctx.expression(0).getText();
        String rhs = values.get(ctx.expression(1));
    
        if (!symbolTable.containsKey(lhsId)) {
            throw new RuntimeException("Błąd semantyczny: zmienna '" + lhsId + "' nie została zadeklarowana.");
        }
    
        if (rhs != null) {
            generator.addMainInstruction("store i32 " + rhs + ", i32* @" + lhsId);
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
                generator.addMainInstruction(leftCond + " = fcmp une double " + result + ", 0.0");
            } else {
                generator.addMainInstruction(leftCond + " = icmp ne i32 " + result + ", 0");
            }
    
            String rightCond = generator.nextRegister();
            if (rightIsDouble) {
                generator.addMainInstruction(rightCond + " = fcmp une double " + right + ", 0.0");
            } else {
                generator.addMainInstruction(rightCond + " = icmp ne i32 " + right + ", 0");
            }
    
            // or i1
            String orResult = generator.nextRegister();
            generator.addMainInstruction(orResult + " = or i1 " + leftCond + ", " + rightCond);
    
            // Rozszerz do i32
            result = generator.nextRegister();
            generator.addMainInstruction(result + " = zext i1 " + orResult + " to i32");
    
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
                generator.addMainInstruction(leftCond + " = fcmp une double " + result + ", 0.0");
            } else {
                generator.addMainInstruction(leftCond + " = icmp ne i32 " + result + ", 0");
            }
    
            String rightCond = generator.nextRegister();
            if (rightIsDouble) {
                generator.addMainInstruction(rightCond + " = fcmp une double " + right + ", 0.0");
            } else {
                generator.addMainInstruction(rightCond + " = icmp ne i32 " + right + ", 0");
            }
    
            // XOR logiczne
            String xorResult = generator.nextRegister();
            generator.addMainInstruction(xorResult + " = xor i1 " + leftCond + ", " + rightCond);
    
            // Rozszerzenie do i32 — gotowe na kolejną iterację lub końcowy wynik
            result = generator.nextRegister();
            generator.addMainInstruction(result + " = zext i1 " + xorResult + " to i32");
    
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
                generator.addMainInstruction(leftCond + " = fcmp une double " + result + ", 0.0");
            } else {
                generator.addMainInstruction(leftCond + " = icmp ne i32 " + result + ", 0");
            }
    
            String rightCond = generator.nextRegister();
            if (rightIsDouble) {
                generator.addMainInstruction(rightCond + " = fcmp une double " + right + ", 0.0");
            } else {
                generator.addMainInstruction(rightCond + " = icmp ne i32 " + right + ", 0");
            }
    
            // AND logiczne
            String andResult = generator.nextRegister();
            generator.addMainInstruction(andResult + " = and i1 " + leftCond + ", " + rightCond);
    
            // Rozszerzenie do i32 — gotowe na kolejną iterację lub użycie końcowe
            result = generator.nextRegister();
            generator.addMainInstruction(result + " = zext i1 " + andResult + " to i32");
    
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
            generator.addMainInstruction(casted + " = sitofp i32 " + left + " to double");
            left = casted;
            symbolTable.put(left, "double");
        }
    
        if ("int".equals(rightType) && isDouble) {
            String casted = generator.nextRegister();
            generator.addMainInstruction(casted + " = sitofp i32 " + right + " to double");
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
        generator.addMainInstruction(result + " = " + cmpInstr + " " + llvmOp + " " + type + " " + left + ", " + right);
    
        // Rozszerzenie do i32
        String extended = generator.nextRegister();
        generator.addMainInstruction(extended + " = zext i1 " + result + " to i32");
    
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
                generator.addMainInstruction(casted + " = sitofp i32 " + result + " to double");
                result = casted;
                symbolTable.put(result, "double");
            }
    
            if ("int".equals(rightType) && isDouble) {
                String casted = generator.nextRegister();
                generator.addMainInstruction(casted + " = sitofp i32 " + right + " to double");
                right = casted;
                symbolTable.put(right, "double");
            }
    
            String temp = generator.nextRegister();
    
            switch (operator) {
                case "+" -> generator.addMainInstruction(temp + " = " + (isDouble ? "fadd double " : "add i32 ") + result + ", " + right);
                case "-" -> generator.addMainInstruction(temp + " = " + (isDouble ? "fsub double " : "sub i32 ") + result + ", " + right);
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
                generator.addMainInstruction(casted + " = sitofp i32 " + result + " to double");
                result = casted;
                symbolTable.put(result, "double");
            }
    
            if ("int".equals(rightType) && isDouble) {
                String casted = generator.nextRegister();
                generator.addMainInstruction(casted + " = sitofp i32 " + right + " to double");
                right = casted;
                symbolTable.put(right, "double");
            }
    
            String temp = generator.nextRegister();
    
            switch (operator) {
                case "*" -> generator.addMainInstruction(temp + " = " + (isDouble ? "fmul double " : "mul i32 ") + result + ", " + right);
                case "/" -> generator.addMainInstruction(temp + " = " + (isDouble ? "fdiv double " : "sdiv i32 ") + result + ", " + right);
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
            generator.addMainInstruction(casted + " = sitofp i32 " + base + " to double");
            base = casted;
            symbolTable.put(base, "double");
        }
    
        if ("int".equals(expType) && isDouble) {
            String casted = generator.nextRegister();
            generator.addMainInstruction(casted + " = sitofp i32 " + exp + " to double");
            exp = casted;
            symbolTable.put(exp, "double");
        }
    
        String result = generator.nextRegister();
    
        if (isDouble) {
            generator.addMainInstruction(result + " = call double @llvm.pow.f64(double " + base + ", double " + exp + ")");
            symbolTable.put(result, "double");
        } else {
            generator.addMainInstruction(result + " = call i32 @powi(i32 " + base + ", i32 " + exp + ")");
            symbolTable.put(result, "int");
        }
    
        values.put(ctx, result);
    }
    

    @Override
    public void exitUnaryExpr(PyPlusPlusParser.UnaryExprContext ctx) {
        if (ctx.getChildCount() == 2 && ctx.getChild(0).getText().equals("!")) {
            if (ctx.unaryExpr() == null) {
                debug("Brak operandu dla operatora !");
                return;
            }
    
            String operand = values.get(ctx.unaryExpr());
    
            if (operand == null) {
                debug("Operand ! nie ma wartości");
                return;
            }
    
            String operandType = symbolTable.get(operand);
            boolean isDouble = "double".equals(operandType);
    
            // Konwersja do boola
            String condition = generator.nextRegister();
            if (isDouble) {
                generator.addMainInstruction(condition + " = fcmp une double " + operand + ", 0.0");
            } else {
                generator.addMainInstruction(condition + " = icmp ne i32 " + operand + ", 0");
            }
    
            // Negacja logiczna (odwrócenie wartości boola)
            String notResult = generator.nextRegister();
            generator.addMainInstruction(notResult + " = xor i1 " + condition + ", true");
    
            // Rozszerzenie i1 -> i32
            String finalResult = generator.nextRegister();
            generator.addMainInstruction(finalResult + " = zext i1 " + notResult + " to i32");
    
            values.put(ctx, finalResult);
            symbolTable.put(finalResult, "int"); // wynik negacji to int (0/1)
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
            generator.addMainInstruction(reg + " = getelementptr inbounds [" + size + " x i8], [" + size + " x i8]* " + strLabel + ", i32 0, i32 0");
    
            values.put(ctx, reg);
            symbolTable.put(reg, "string");  // more readable name instead of i8*
        }
        else if (val.contains(".")) {
            generator.addMainInstruction(reg + " = fadd double 0.0, " + val);
            values.put(ctx, reg);
            symbolTable.put(reg, "double");
        } 
        else {
            generator.addMainInstruction(reg + " = add i32 0, " + val);
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
    
            if ("double".equals(varType)) {
                generator.addMainInstruction(reg + " = load double, double* @" + varName);
                symbolTable.put(reg, "double");
            } else if ("string".equals(varType)) {
                generator.addMainInstruction(reg + " = load i8*, i8** @" + varName);
                symbolTable.put(reg, "string");
            } else {
                generator.addMainInstruction(reg + " = load i32, i32* @" + varName);
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
                            generator.addMainInstruction(
                                dummy + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds " +
                                "([4 x i8], [4 x i8]* @format_double, i32 0, i32 0), double " + argValue + ")"
                            );
                        } else if ("string".equals(type)) {
                            generator.addMainInstruction(
                                dummy + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds " +
                                "([4 x i8], [4 x i8]* @format_string, i32 0, i32 0), i8* " + argValue + ")"
                            );
                        } else {
                            generator.addMainInstruction(
                                dummy + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds " +
                                "([4 x i8], [4 x i8]* @format, i32 0, i32 0), i32 " + argValue + ")"
                            );
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
    
                generator.addMainInstruction(allocaReg + " = alloca double");
                generator.addMainInstruction(
                    dummy + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds " +
                    "([4 x i8], [4 x i8]* @read_format_double, i32 0, i32 0), double* " + allocaReg + ")"
                );
                generator.addMainInstruction(loadReg + " = load double, double* " + allocaReg);
                symbolTable.put(loadReg, "double");
    
                values.put(ctx, loadReg);
            }
    
            else {
                debug("Nieznana funkcja: " + functionName);
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
                    generator.addMainInstruction(casted + " = fptosi double " + val + " to i32");
                    generator.addMainInstruction("ret i32 " + casted);
                } else {
                    generator.addMainInstruction("ret i32 " + val);
                }
            } else {
                debug("Brak wartości w return");
                generator.addMainInstruction("ret i32 0");
            }
        } else {
            generator.addMainInstruction("ret i32 0");
        }
    }

    @Override
    public void exitWhile_loop(PyPlusPlusParser.While_loopContext ctx) {
        String condLabel = "while.cond" + generator.nextLabelId();
        String bodyLabel = "while.body" + generator.nextLabelId();
        String endLabel = "while.end" + generator.nextLabelId();
    
        // Skok do warunku
        generator.addMainInstruction("br label %" + condLabel);
    
        // LABEL: while.cond
        generator.addMainInstruction(condLabel + ":");
    
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
            generator.addMainInstruction(cond_i1 + " = fcmp une double " + condReg + ", 0.0");
            cmpReg = cond_i1;
        } else {
            String cond_i1 = generator.nextRegister();
            generator.addMainInstruction(cond_i1 + " = icmp ne i32 " + condReg + ", 0");
            cmpReg = cond_i1;
        }
    
        generator.addMainInstruction("br i1 " + cmpReg + ", label %" + bodyLabel + ", label %" + endLabel);
    
        // LABEL: while.body
        generator.addMainInstruction(bodyLabel + ":");
    
        for (PyPlusPlusParser.StatementContext stmt : ctx.statement()) {
            ParseTreeWalker.DEFAULT.walk(this, stmt);
        }
    
        // Po ciele pętli, wracamy do sprawdzenia warunku
        generator.addMainInstruction("br label %" + condLabel);
    
        // LABEL: while.end
        generator.addMainInstruction(endLabel + ":");
    }
    

    public String getLLVMCode() {
        return generator.generate();
    }
}

// CHECKPOINT;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;