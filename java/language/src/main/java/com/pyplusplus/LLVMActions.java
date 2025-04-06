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
        symbolTable.put(varName, "int"); // dla uproszczenia typ int
    
        generator.declareVariable(varName);
    
        if (ctx.expression() != null) {
            if (ctx.expression() instanceof PyPlusPlusParser.FunctionCallExprContext functionCtx) {
                String functionName = functionCtx.function_call().IDENTIFIER().getText();
                if (functionName.equals("read")) {
                    // Upewnij się, że wartość z read() została wygenerowana
                    String readValue = values.get(ctx.expression());
                    generator.addMainInstruction("store i32 " + readValue + ", i32* @" + varName);
                    return;
                }
            }
        
            String valueReg = values.get(ctx.expression());
            if (valueReg != null) {
                generator.addMainInstruction("store i32 " + valueReg + ", i32* @" + varName);
            } else {
                debug("Brak wartości dla 'var " + varName + "'");
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
    public void exitMulExpr(PyPlusPlusParser.MulExprContext ctx) {
        String operator = ctx.getChild(1).getText();
        String left = values.get(ctx.expression(0));
        String right = values.get(ctx.expression(1));
        String result = generator.nextRegister();

        if (operator.equals("*")) {
            generator.addMainInstruction(result + " = mul i32 " + left + ", " + right);
        } else if (operator.equals("/")) {
            generator.addMainInstruction(result + " = sdiv i32 " + left + ", " + right);
        }
        values.put(ctx, result);
    }

    @Override
    public void exitAddExpr(PyPlusPlusParser.AddExprContext ctx) {
        String operator = ctx.getChild(1).getText();
        String left = values.get(ctx.expression(0));
        String right = values.get(ctx.expression(1));
        String result = generator.nextRegister();
    
        if (operator.equals("+")) {
            generator.addMainInstruction(result + " = add i32 " + left + ", " + right);
        } else if (operator.equals("-")) {
            generator.addMainInstruction(result + " = sub i32 " + left + ", " + right);
        }
        values.put(ctx, result);
    }

    @Override
    public void exitPowExpr(PyPlusPlusParser.PowExprContext ctx) {
        String base = values.get(ctx.expression(0));
        String exp = values.get(ctx.expression(1));
        String result = generator.nextRegister();

        // wywołanie naszej funkcji pomocniczej
        generator.addMainInstruction(result + " = call i32 @powi(i32 " + base + ", i32 " + exp + ")");
        if (base == null || exp == null) {
            debug("Brakuje operandów dla potęgowania: base=" + base + ", exp=" + exp);
            return;
        }
        values.put(ctx, result);
    }

    @Override
    public void exitParensExpr(PyPlusPlusParser.ParensExprContext ctx) {
        // Po prostu przekaż wartość z wnętrza nawiasów dalej
        String inner = values.get(ctx.expression());
        values.put(ctx, inner);
    }

    @Override
    public void exitComparisonExpr(PyPlusPlusParser.ComparisonExprContext ctx) {
        String left = values.get(ctx.expression(0));
        String right = values.get(ctx.expression(1));
        String result = generator.nextRegister();

        String op = ctx.getChild(1).getText(); // pobieramy operator jako środkowy child
        String llvmOp;

        switch(op) {
            case "==": llvmOp = "eq"; break;
            case "!=": llvmOp = "ne"; break;
            case "<":  llvmOp = "slt"; break;
            case "<=": llvmOp = "sle"; break;
            case ">":  llvmOp = "sgt"; break;
            case ">=": llvmOp = "sge"; break;
            default:
                debug("Nieznany operator porównania: " + op);
                return;
        }

        generator.addMainInstruction(result + " = icmp " + llvmOp + " i32 " + left + ", " + right);

        // i1 trzeba zrzutować do i32, żeby móc używać np. w printf
        String extended = generator.nextRegister();
        generator.addMainInstruction(extended + " = zext i1 " + result + " to i32");

        values.put(ctx, extended); // do dalszego użycia (np. przypisania lub print)
    }

    @Override
    public void exitLogicalOrExpr(PyPlusPlusParser.LogicalOrExprContext ctx) {
        String left = values.get(ctx.expression(0));
        String right = values.get(ctx.expression(1));

        if (left == null || right == null) {
            debug("Brakuje operandów dla ||");
            return;
        }

        // Sprawdzenie, czy lewy operand jest różny od zera
        String leftCond = generator.nextRegister();
        generator.addMainInstruction(leftCond + " = icmp ne i32 " + left + ", 0");

        // Sprawdzenie, czy prawy operand jest różny od zera
        String rightCond = generator.nextRegister();
        generator.addMainInstruction(rightCond + " = icmp ne i32 " + right + ", 0");

        // OR logiczne na wynikach
        String orResult = generator.nextRegister();
        generator.addMainInstruction(orResult + " = or i1 " + leftCond + ", " + rightCond);

        // Rozszerzamy do i32
        String finalResult = generator.nextRegister();
        generator.addMainInstruction(finalResult + " = zext i1 " + orResult + " to i32");

        values.put(ctx, finalResult);
    }

    @Override
    public void exitLogicalAndExpr(PyPlusPlusParser.LogicalAndExprContext ctx) {
        String left = values.get(ctx.expression(0));
        String right = values.get(ctx.expression(1));

        if (left == null || right == null) {
            debug("Brakuje operandów dla &&");
            return;
        }

        // Sprawdzenie, czy operand ≠ 0
        String leftCond = generator.nextRegister();
        generator.addMainInstruction(leftCond + " = icmp ne i32 " + left + ", 0");

        String rightCond = generator.nextRegister();
        generator.addMainInstruction(rightCond + " = icmp ne i32 " + right + ", 0");

        // AND logiczne
        String andResult = generator.nextRegister();
        generator.addMainInstruction(andResult + " = and i1 " + leftCond + ", " + rightCond);

        // Rozszerzenie do i32
        String finalResult = generator.nextRegister();
        generator.addMainInstruction(finalResult + " = zext i1 " + andResult + " to i32");

        values.put(ctx, finalResult);
    }

    @Override
    public void exitLiteralExpr(PyPlusPlusParser.LiteralExprContext ctx) {
        String val = ctx.getText();
        String reg = generator.nextRegister();
        generator.addMainInstruction(reg + " = add i32 0, " + val);
        values.put(ctx, reg);
    }

    @Override
    public void exitIdentifierExpr(PyPlusPlusParser.IdentifierExprContext ctx) {
        String varName = ctx.getText();
    
        if (!symbolTable.containsKey(varName)) {
            throw new RuntimeException("Błąd semantyczny: zmienna '" + varName + "' nie została zadeklarowana.");
        }
    
        String reg = generator.nextRegister();
        generator.addMainInstruction(reg + " = load i32, i32* @" + varName);
        values.put(ctx, reg);
    }

    @Override
    public void exitReturn_statement(PyPlusPlusParser.Return_statementContext ctx) {
        if (ctx.expression() != null) {
            String val = values.get(ctx.expression());
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

    @Override
    public void exitFunctionCallExpr(PyPlusPlusParser.FunctionCallExprContext ctx) {
        String functionName = ctx.function_call().IDENTIFIER().getText();

        // Obsługa specjalna dla print()
        if (functionName.equals("print")) {
            if (ctx.function_call().expression(0) != null) {
                String argValue = values.get(ctx.function_call().expression(0));
                if (argValue != null) {
                    generator.addMainInstruction(
                        "call i32 (i8*, ...) @printf(i8* getelementptr inbounds " +
                        "([4 x i8], [4 x i8]* @format, i32 0, i32 0), i32 " + argValue + ")"
                    );
                } else {
                    debug("Brak wartości do wypisania w print()");
                }
            }
        } else if (functionName.equals("read")) {

            String allocaReg = "%read_tmp";
            generator.addMainInstruction(allocaReg + " = alloca i32");
            
            generator.addMainInstruction(
                "call i32 (i8*, ...) @scanf(i8* getelementptr inbounds " +
                "([3 x i8], [3 x i8]* @read_format, i32 0, i32 0), i32* " + allocaReg + ")"
            );
            
            String loadReg = generator.nextRegister();
            generator.addMainInstruction(loadReg + " = load i32, i32* " + allocaReg);
            values.put(ctx, loadReg);
                    
        }
    }


    public String getLLVMCode() {
        return generator.generate();
    }
}
