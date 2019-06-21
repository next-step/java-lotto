package com.jaeyeonling.calculate;


public final class StringAddCalculator {

    private StringAddCalculator() { }

    public static int execute(final String expression) {
        return new Expression(expression).execute();
    }
}
