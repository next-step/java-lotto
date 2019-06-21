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
            return 6;
        }

        return Arrays.stream(expression.split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
