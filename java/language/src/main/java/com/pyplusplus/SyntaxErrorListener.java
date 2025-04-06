package com.pyplusplus;

import org.antlr.v4.runtime.*;

public class SyntaxErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {
        String sourceName = recognizer.getInputStream().getSourceName();
        if (!sourceName.isEmpty()) {
            sourceName = String.format("%s:", sourceName);
        }

        // Rozróżniamy błąd leksykalny vs składniowy
        if (recognizer instanceof Lexer) {
            System.err.printf("[Błąd leksykalny] %s Linia %d:%d → %s%n",
                    sourceName, line, charPositionInLine, msg);
        } else {
            System.err.printf("[Błąd składniowy] %s Linia %d:%d → %s%n",
                    sourceName, line, charPositionInLine, msg);
        }
    }
}
