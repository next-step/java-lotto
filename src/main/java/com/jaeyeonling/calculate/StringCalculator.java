package com.jaeyeonling.calculate;

import java.util.Arrays;

final class StringCalculator {

    private static final String SEPARATOR = ",|:";

    private StringCalculator() { }

    static int add(final String expression) {
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
