package com.jaeyeonling.calculate;

import java.util.Arrays;

public class Expression {

    private static final String SEPARATOR = ",|:";
    private static final String CUSTOM_PREFIX = "//";
    private static final String NEW_LINE = "\n";

    private final String separator;
    private final String expression;

    private Expression(final String separator, final String expression) {
        this.separator = separator;
        this.expression = expression;
    }

    public static Expression of(final String expression) {
        if (!expression.startsWith(CUSTOM_PREFIX)) {
            return new Expression(SEPARATOR, expression);
        }

        final String[] splitExpression = expression.split(NEW_LINE);
        final String separator = splitExpression[0].substring(CUSTOM_PREFIX.length());
        final String value = splitExpression[1];

        return new Expression(separator, value);
    }

    public int execute() {
        if (expression.isEmpty()) {
            return 0;
        }

        return Arrays.stream(expression.split(separator))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
