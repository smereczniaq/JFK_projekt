package com.pyplusplus;

public class LLVMGenerator {
    private StringBuilder header = new StringBuilder();
    private StringBuilder main = new StringBuilder();
    private int registerCount = 1;

    public LLVMGenerator() {
        header.append("@format = private unnamed_addr constant [4 x i8] c\"%d\\0A\\00\"\n");
        header.append("declare i32 @printf(i8*, ...)\n");
        header.append("@read_format = private unnamed_addr constant [3 x i8] c\"%d\\00\"\n");
        header.append("declare i32 @scanf(i8*, ...)\n");
    }

    public String nextRegister() {
        System.out.println("Register: %" + registerCount);
        return "%" + registerCount++;
    }

    public void addMainInstruction(String instruction) {
        main.append("  ").append(instruction).append("\n");
    }

    public void declareVariable(String name) {
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
        return sb.toString();
    }
}
