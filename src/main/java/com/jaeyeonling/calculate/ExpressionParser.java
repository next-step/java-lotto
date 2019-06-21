package com.jaeyeonling.calculate;

public final class ExpressionParser {

    private static final String CUSTOM_PREFIX = "//";
    private static final String NEW_LINE = "\n";

    public static String parseExpressionStatement(final String expression) {
        if (expression.startsWith(CUSTOM_PREFIX)) {
            return expression.split(NEW_LINE)[1];
        }

        return expression;
    }
}
