package com.jaeyeonling.calculate;

import java.util.Arrays;

public final class StringAddCalculator {

    private static final String SEPARATOR = ",|:";

    private StringAddCalculator() { }

    public static int execute(final String expression) {
        if (expression == null || expression.isBlank()) {
            return 0;
        }

        return Arrays.stream(expression.split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
