package com.jaeyeonling.calculate;

import java.util.Arrays;

public class Expression {

    private static final String SEPARATOR = ",|:";

    private final String expression;

    private Expression(final String expression) {
        this.expression = expression;
    }

    public static Expression of(final String expression) {
        return new Expression(expression);
    }

    public int execute() {
        if (expression.isEmpty()) {
            return 0;
        }

        if (expression.startsWith("//")) {
            final String[] splitExpression = expression.split("\n");
            final String separator = splitExpression[0].substring(2);
            final String value = splitExpression[1];

            return Arrays.stream(value.split(separator))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        return Arrays.stream(expression.split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
