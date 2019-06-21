package com.jaeyeonling.calculate;

import java.util.Arrays;

public final class StringAddCalculator {

    private static final String SEPARATOR = ",";

    private StringAddCalculator() { }

    public static int execute(String source) {
        if (source == null || source.isBlank()) {
            return 0;
        }

        return Arrays.stream(source.split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
