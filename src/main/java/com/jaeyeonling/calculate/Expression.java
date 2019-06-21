package com.jaeyeonling.calculate;

import com.jaeyeonling.calculate.utils.StringUtils;

import java.util.Arrays;

class Expression {

    private static final String CUSTOM_PREFIX = "//";
    static final String NEW_LINE = "\n";

    private final Separator separator;
    private final String expression;

    private Expression(final Separator separator,
                       final String expression) {
        this.separator = separator;
        this.expression = expression;
    }

    public static Expression of(final String expression) {
        return new Expression(
                Separator.of(expression),
                expression);
    }

    public int execute() {
        if (StringUtils.isNullOrBlank(expression)) {
            return 0;
        }

        return Arrays.stream(separator.split(getValue()))
                .mapToInt(this::parseInt)
                .sum();
    }

    private int parseInt(final String s) {
        final int parsedValue = Integer.parseInt(s);
        if (parsedValue < 0) {
            throw new IllegalArgumentException();
        }

        return parsedValue;
    }

    static boolean isCustomExpression(final String expression) {
        return expression.startsWith(CUSTOM_PREFIX);
    }

    private String getValue() {
        if (isCustomExpression(expression)) {
            final String[] splitExpression = expression.split(NEW_LINE);

            return splitExpression[1];
        }

        return expression;
    }
}
