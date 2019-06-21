package com.jaeyeonling.calculate;

import java.util.Arrays;

public final class StringAddCalculator {

    private StringAddCalculator() { }

    public static int execute(String source) {
        if (source == null || source.isBlank()) {
            return 0;
        }

        return Arrays.stream(source.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
