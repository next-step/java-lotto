package com.jaeyeonling.calculate;

import com.jaeyeonling.calculate.utils.StringUtils;

import java.util.Arrays;

class Expression {

    static final String NEW_LINE = "\n";
    private static final String CUSTOM_PREFIX = "//";

    private final Separator separator;
    private final ExpressionValue value;

    private Expression(final Separator separator,
                       final ExpressionValue value) {
        this.separator = separator;
        this.value = value;
    }

    public static Expression of(final String expression) {
        return new Expression(
                Separator.of(expression),
                ExpressionValue.of(expression));
    }

    public int execute() {
        if (value.isEmpty()) {
            return 0;
        }

        return Arrays.stream(value.split(separator))
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
}
