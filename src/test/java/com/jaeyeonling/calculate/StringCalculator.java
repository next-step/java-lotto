package com.jaeyeonling.calculate;

import java.util.Arrays;

final class StringCalculator {

    private StringCalculator() { }

    static int add(final String expression) {
        if (expression.isEmpty()) {
            return 0;
        }

        return Arrays.stream(expression.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
