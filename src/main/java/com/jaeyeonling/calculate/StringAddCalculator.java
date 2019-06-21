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

            return Arrays.stream(value.split(separator))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        return Arrays.stream(expression.split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
