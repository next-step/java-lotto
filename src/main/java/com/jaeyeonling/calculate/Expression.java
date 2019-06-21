package com.jaeyeonling.calculate;

import java.util.Arrays;

public class Expression {

    private static final String SEPARATOR = ",|:";

    private final String separator;
    private final String expression;

    private Expression(final String separator, final String expression) {
        this.separator = separator;
        this.expression = expression;
    }

    public static Expression of(final String expression) {
        if (!expression.startsWith("//")) {
            return new Expression(SEPARATOR, expression);
        }

        final String[] splitExpression = expression.split("\n");
        final String separator = splitExpression[0].substring(2);
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
