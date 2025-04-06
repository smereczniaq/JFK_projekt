package com.pyplusplus;

import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

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
    
        symbolTable.put(varName, "int"); // uproszczenie: wszystkie zmienne typu int
        generator.declareVariable(varName);
        System.out.println(ctx.expression());
        if (ctx.expression() != null) {
            String valueReg = values.get(ctx.expression());
    
            if (valueReg != null) {
                generator.addMainInstruction("store i32 " + valueReg + ", i32* @" + varName);
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
    
            // Konwersja operandów do i1
            String leftCond = generator.nextRegister();
            generator.addMainInstruction(leftCond + " = icmp ne i32 " + result + ", 0");
    
            String rightCond = generator.nextRegister();
            generator.addMainInstruction(rightCond + " = icmp ne i32 " + right + ", 0");
    
            // OR logiczne
            String orResult = generator.nextRegister();
            generator.addMainInstruction(orResult + " = or i1 " + leftCond + ", " + rightCond);
    
            // Rozszerzenie do i32
            result = generator.nextRegister();
            generator.addMainInstruction(result + " = zext i1 " + orResult + " to i32");
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
    
            // Konwersja operandów do i1
            String leftCond = generator.nextRegister();
            generator.addMainInstruction(leftCond + " = icmp ne i32 " + result + ", 0");
    
            String rightCond = generator.nextRegister();
            generator.addMainInstruction(rightCond + " = icmp ne i32 " + right + ", 0");
    
            // XOR logiczne
            String xorResult = generator.nextRegister();
            generator.addMainInstruction(xorResult + " = xor i1 " + leftCond + ", " + rightCond);
    
            // Rozszerzenie do i32 — gotowe na kolejną iterację lub końcowy wynik
            result = generator.nextRegister();
            generator.addMainInstruction(result + " = zext i1 " + xorResult + " to i32");
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
    
            // Konwersja operandów do i1
            String leftCond = generator.nextRegister();
            generator.addMainInstruction(leftCond + " = icmp ne i32 " + result + ", 0");
    
            String rightCond = generator.nextRegister();
            generator.addMainInstruction(rightCond + " = icmp ne i32 " + right + ", 0");
    
            // AND logiczne
            String andResult = generator.nextRegister();
            generator.addMainInstruction(andResult + " = and i1 " + leftCond + ", " + rightCond);
    
            // Rozszerzenie do i32 — gotowe na kolejną iterację lub użycie końcowe
            result = generator.nextRegister();
            generator.addMainInstruction(result + " = zext i1 " + andResult + " to i32");
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
        String operator = ctx.getChild(1).getText(); // operator między operandami
        String llvmOp;
    
        switch(operator) {
            case "==": llvmOp = "eq"; break;
            case "!=": llvmOp = "ne"; break;
            case "<":  llvmOp = "slt"; break;
            case "<=": llvmOp = "sle"; break;
            case ">":  llvmOp = "sgt"; break;
            case ">=": llvmOp = "sge"; break;
            default:
                debug("Nieznany operator porównania: " + operator);
                return;
        }
    
        String result = generator.nextRegister();
        generator.addMainInstruction(result + " = icmp " + llvmOp + " i32 " + left + ", " + right);
    
        String extended = generator.nextRegister();
        generator.addMainInstruction(extended + " = zext i1 " + result + " to i32");
    
        values.put(ctx, extended);
    }
    

    @Override
    public void exitAddExpr(PyPlusPlusParser.AddExprContext ctx) {
        int count = ctx.mulExpr().size();
    
        if (count == 1) {
            values.put(ctx, values.get(ctx.mulExpr(0)));
            return;
        }
    
        String result = values.get(ctx.mulExpr(0));
        if (result == null) {
            debug("Brakuje lewego operandu w addExpr");
            return;
        }
    
        for (int i = 1; i < count; i++) {
            String right = values.get(ctx.mulExpr(i));
            String operator = ctx.getChild(2 * i - 1).getText(); // '+' lub '-'
    
            if (right == null) {
                debug("Brakuje prawego operandu w addExpr");
                return;
            }
    
            String temp = generator.nextRegister();
    
            if (operator.equals("+")) {
                generator.addMainInstruction(temp + " = add i32 " + result + ", " + right);
            } else if (operator.equals("-")) {
                generator.addMainInstruction(temp + " = sub i32 " + result + ", " + right);
            } else {
                debug("Nieznany operator w addExpr: " + operator);
                return;
            }
    
            result = temp;
        }
    
        values.put(ctx, result);
    }
    

    @Override
    public void exitMulExpr(PyPlusPlusParser.MulExprContext ctx) {
        if (ctx.powExpr().size() == 1) {
            values.put(ctx, values.get(ctx.powExpr(0)));
            return;
        }
    
        String result = values.get(ctx.powExpr(0));
    
        for (int i = 1; i < ctx.powExpr().size(); i++) {
            String right = values.get(ctx.powExpr(i));
            String operator = ctx.getChild(2 * i - 1).getText(); // operator jest między operandami
    
            String temp = generator.nextRegister();
    
            if (operator.equals("*")) {
                generator.addMainInstruction(temp + " = mul i32 " + result + ", " + right);
            } else if (operator.equals("/")) {
                generator.addMainInstruction(temp + " = sdiv i32 " + result + ", " + right);
            }
    
            result = temp;
        }
    
        values.put(ctx, result);
    }
    

    @Override
    public void exitPowExpr(PyPlusPlusParser.PowExprContext ctx) {
        String base = values.get(ctx.unaryExpr());
        if (ctx.powExpr() == null) {
            // tylko jedna wartość — przekazujemy w górę bez operacji
            values.put(ctx, base);
            return;
        }

        String exp = ctx.powExpr() != null ? values.get(ctx.powExpr()) : null;
    
        if (base == null || (ctx.powExpr() != null && exp == null)) {
            debug("Brakuje operandów dla potęgowania");
            return;
        }
    
        String result;
        if (exp != null) {
            result = generator.nextRegister();
            generator.addMainInstruction(result + " = call i32 @powi(i32 " + base + ", i32 " + exp + ")");
        } else {
            result = base; // bez potęgowania, tylko pojedynczy operand
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
    
            // Konwersja do boola
            String condition = generator.nextRegister();
            generator.addMainInstruction(condition + " = icmp ne i32 " + operand + ", 0");
    
            // Negacja logiczna (odwrócenie wartości boola)
            String notResult = generator.nextRegister();
            generator.addMainInstruction(notResult + " = xor i1 " + condition + ", true");
    
            // Rozszerzenie i1 -> i32
            String finalResult = generator.nextRegister();
            generator.addMainInstruction(finalResult + " = zext i1 " + notResult + " to i32");
    
            values.put(ctx, finalResult);
        } else if (ctx.primary() != null) {
            String val = values.get(ctx.primary());
            values.put(ctx, val);
        } else {
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
        generator.addMainInstruction(reg + " = add i32 0, " + val);
        values.put(ctx, reg);
    }    

    @Override
    public void exitPrimary(PyPlusPlusParser.PrimaryContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            String varName = ctx.IDENTIFIER().getText();
    
            if (!symbolTable.containsKey(varName)) {
                throw new RuntimeException("Błąd semantyczny: zmienna '" + varName + "' nie została zadeklarowana.");
            }
    
            String reg = generator.nextRegister();
            generator.addMainInstruction(reg + " = load i32, i32* @" + varName);
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
                        String dummy = generator.nextRegister(); // zabezpieczenie rejestru
                        generator.addMainInstruction(
                            dummy + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds " +
                            "([4 x i8], [4 x i8]* @format, i32 0, i32 0), i32 " + argValue + ")"
                        );
                    } else {
                        debug("Brak wartości do wypisania w print()");
                    }
                }
                values.put(ctx, "0");
            }
        
            else if (functionName.equals("read")) {
                // rejestr na wskaźnik alloca
                String allocaReg = generator.nextRegister();
                generator.addMainInstruction(allocaReg + " = alloca i32");
        
                // przypisz wywołanie scanf do dummy żeby zarejestrować użycie
                String dummy = generator.nextRegister();
                generator.addMainInstruction(
                    dummy + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds " +
                    "([3 x i8], [3 x i8]* @read_format, i32 0, i32 0), i32* " + allocaReg + ")"
                );
        
                // załaduj wartość wczytaną z pamięci
                String loadReg = generator.nextRegister();
                generator.addMainInstruction(loadReg + " = load i32, i32* " + allocaReg);
        
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
            System.out.println(val);
            if (val != null) {
                generator.addMainInstruction("ret i32 " + val);
            } else {
                debug("Brak wartości w return");
                generator.addMainInstruction("ret i32 0");
            }
        } else {
            generator.addMainInstruction("ret i32 0");
        }
    }

    public String getLLVMCode() {
        return generator.generate();
    }
}

// CHECKPOINT;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;