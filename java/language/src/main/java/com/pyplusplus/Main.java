package com.pyplusplus;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromFileName("example.pypp");
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
