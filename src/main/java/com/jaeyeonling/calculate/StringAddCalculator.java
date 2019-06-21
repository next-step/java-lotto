package com.jaeyeonling.calculate;

public final class StringAddCalculator {

    private StringAddCalculator() {

    }

    public static int execute(String source) {
        if (source == null || source.isBlank()) {
            return 0;
        }

        return Integer.parseInt(source);
    }
}
