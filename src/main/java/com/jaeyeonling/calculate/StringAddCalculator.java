package com.jaeyeonling.calculate;

import java.util.Arrays;

public final class StringAddCalculator {

    private static final String SEPARATOR = ",|:";
    private static final String CUSTOM_PREFIX = "//";
    private static final String NEW_LINE = "\n";

    private StringAddCalculator() { }

    public static int execute(final String expression) {
        if (isInvalidExpression(expression)) {
            return 0;
        }

        final String separator = getSeparator(expression);
        final String value = getValue(expression);

        return execute(separator, value);
    }

    private static String getValue(String expression) {
        if (isCustomExpression(expression)) {
            final String[] splitExpression = expression.split(NEW_LINE);

            return splitExpression[1];
        }

        return expression;
    }

    private static String getSeparator(String expression) {
        if (isCustomExpression(expression)) {
            final String[] splitExpression = expression.split(NEW_LINE);

            return splitExpression[0].substring(2);
        }

        return SEPARATOR;
    }

    private static boolean isCustomExpression(String expression) {
        return expression.startsWith(CUSTOM_PREFIX);
    }

    private static boolean isInvalidExpression(String expression) {
        return expression == null || expression.isBlank();
    }

    private static int execute(final String separator,
                               final String expression) {
        return Arrays.stream(expression.split(separator))
                .mapToInt(StringAddCalculator::parseInt)
                .sum();
    }

    private static int parseInt(final String s) {
        final int parsedValue = Integer.parseInt(s);
        if (parsedValue < 0) {
            throw new IllegalArgumentException();
        }

        return parsedValue;
    }
}
