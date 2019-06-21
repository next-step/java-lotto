package com.jaeyeonling.calculate;

public final class StringAddCalculator {

    private StringAddCalculator() { }

    public static int execute(final String expression) {
        return Expression.of(expression).execute();
    }
}
