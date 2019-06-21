package com.jaeyeonling.calculate;

public final class ExpressionParser {

    public static String parseExpressionStatement(final String expression) {
        if (expression.startsWith("//")) {
            return expression.split("\n")[1];
        }

        return expression;
    }
}
