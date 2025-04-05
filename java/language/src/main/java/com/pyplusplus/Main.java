package com.pyplusplus;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromFileName("example.pypp");
        PyPlusPlusLexer lexer = new PyPlusPlusLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PyPlusPlusParser parser = new PyPlusPlusParser(tokens);

        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }
}
