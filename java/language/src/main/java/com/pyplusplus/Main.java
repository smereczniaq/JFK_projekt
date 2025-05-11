package com.pyplusplus;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
    public static void main(String[] args) throws Exception {
        // String fileName = "test_programs/test_or.pypp";
        // String fileName = "test_programs/test_xor.pypp";
        // String fileName = "test_programs/test_and.pypp";
        // String fileName = "test_programs/test_cmp.pypp";
        // String fileName = "test_programs/test_pow.pypp";
        // String fileName = "test_programs/test_math.pypp";
        // String fileName = "test_programs/test_logic.pypp";
        // String fileName = "test_programs/test_read.pypp";
        // String fileName = "test_programs/test_read_contexts.pypp";
        // String fileName = "test_programs/test_errors.pypp";
        // String fileName = "test_programs/test_while.pypp";
        String fileName = "test_programs/test_for.pypp";

        CharStream input = CharStreams.fromFileName(fileName);
        PyPlusPlusLexer lexer = new PyPlusPlusLexer(input);
        lexer.removeErrorListeners(); // usuń domyślny
        lexer.addErrorListener(new SyntaxErrorListener());

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PyPlusPlusParser parser = new PyPlusPlusParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new SyntaxErrorListener());

        ParseTree tree = parser.prog();
        // System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        LLVMActions llvmActions = new LLVMActions();
        walker.walk(llvmActions, tree);

        String llvmIR = llvmActions.getLLVMCode();
        Files.write(Paths.get("output.ll"), llvmIR.getBytes());
    }
}
