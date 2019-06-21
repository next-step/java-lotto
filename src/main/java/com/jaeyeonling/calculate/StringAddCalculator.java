package com.jaeyeonling.calculate;

import java.util.Arrays;

public final class StringAddCalculator {

    private static final String SEPARATOR = ",|:";
    private static final String CUSTOM_PREFIX = "//";
    private static final String NEW_LINE = "\n";

    private StringAddCalculator() { }

    public static int execute(final String expression) {
        if (expression == null || expression.isBlank()) {
            return 0;
        }

        if (expression.startsWith(CUSTOM_PREFIX)) {
            final String[] splitExpression = expression.split(NEW_LINE);

            final String separator = splitExpression[0].substring(2);
            final String value = splitExpression[1];

            return execute(separator, value);
        }

        return execute(SEPARATOR, expression);
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
