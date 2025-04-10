package com.pyplusplus;

public class LLVMGenerator {
    private StringBuilder header = new StringBuilder();
    private StringBuilder main = new StringBuilder();
    private int registerCount = 1;

    public LLVMGenerator() {
        header.append("@format = private unnamed_addr constant [4 x i8] c\"%d\\0A\\00\"\n");
        header.append("@format_double = private unnamed_addr constant [4 x i8] c\"%f\\0A\\00\"\n");
        header.append("@read_format = private unnamed_addr constant [3 x i8] c\"%d\\00\"\n");
        header.append("@read_format_double = private unnamed_addr constant [4 x i8] c\"%lf\\00\"\n");
        header.append("declare i32 @printf(i8*, ...)\n");
        header.append("declare i32 @scanf(i8*, ...)\n");
        header.append("declare double @llvm.pow.f64(double, double)\n");
    }
    

    public String nextRegister() {
        return "%" + registerCount++;
    }

    public void addMainInstruction(String instruction) {
        main.append("  ").append(instruction).append("\n");
    }

    public void declareIntegerVariable(String name) {
        header.append("@").append(name).append(" = global i32 0\n");
    }

    public void declareDoubleVariable(String name) {
        header.append("@").append(name).append(" = global double 0.0\n");
    }    

    public String generate() {
        StringBuilder sb = new StringBuilder();
        sb.append(header);
        sb.append("\n");
        sb.append("define i32 @main() {\n");
        sb.append("entry:\n");
        sb.append(main);
        sb.append("  ret i32 0\n");
        sb.append("}\n");

            // funkcja pomocnicza: potęgowanie przez iterację
        sb.append("\n");
        sb.append("define i32 @powi(i32 %base, i32 %exp) {\n");
        sb.append("entry:\n");
        sb.append("  %result = alloca i32\n");
        sb.append("  %i = alloca i32\n");
        sb.append("  store i32 1, i32* %result\n");
        sb.append("  store i32 0, i32* %i\n");
        sb.append("  br label %loop\n");
        sb.append("\n");
        sb.append("loop:\n");
        sb.append("  %i_val = load i32, i32* %i\n");
        sb.append("  %cond = icmp slt i32 %i_val, %exp\n");
        sb.append("  br i1 %cond, label %body, label %end\n");
        sb.append("\n");
        sb.append("body:\n");
        sb.append("  %res_val = load i32, i32* %result\n");
        sb.append("  %res_mul = mul i32 %res_val, %base\n");
        sb.append("  store i32 %res_mul, i32* %result\n");
        sb.append("  %i_next = add i32 %i_val, 1\n");
        sb.append("  store i32 %i_next, i32* %i\n");
        sb.append("  br label %loop\n");
        sb.append("\n");
        sb.append("end:\n");
        sb.append("  %final = load i32, i32* %result\n");
        sb.append("  ret i32 %final\n");
        sb.append("}\n");

        return sb.toString();
    }
}
