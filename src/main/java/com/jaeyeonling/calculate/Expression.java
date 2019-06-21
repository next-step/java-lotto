package com.jaeyeonling.calculate;

import java.util.Arrays;

public class Expression {

    private static final String SEPARATOR = ",|:";
    private static final String CUSTOM_PREFIX = "//";
    private static final String NEW_LINE = "\n";

    private final String separator;
    private final String value;

    private Expression(final String separator,
                       final String value) {
        this.separator = separator;
        this.value = value;
    }

    public static Expression of(final String expression) {
        return new Expression(
                getSeparator(expression),
                getValue(expression));
    }

    public int execute() {
        if (isInvalidExpression()) {
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

    private boolean isInvalidExpression() {
        return value == null || value.isBlank();
    }

    private static boolean isCustomExpression(final String expression) {
        return expression.startsWith(CUSTOM_PREFIX);
    }

    private static String getValue(final String expression) {
        if (isCustomExpression(expression)) {
            final String[] splitExpression = expression.split(NEW_LINE);

            return splitExpression[1];
        }

        return expression;
    }

    private static String getSeparator(final String expression) {
        if (isCustomExpression(expression)) {
            final String[] splitExpression = expression.split(NEW_LINE);

            return splitExpression[0].substring(2);
        }

        return SEPARATOR;
    }
}
