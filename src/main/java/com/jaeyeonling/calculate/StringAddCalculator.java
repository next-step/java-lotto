package com.jaeyeonling.calculate;

public final class StringAddCalculator {

    private static final int ZERO = 0;

    private StringAddCalculator() { }

    public static int execute(final String input) {
        final Expression expression = new Expression(input);
        if (expression.isInvalid()) {
            return ZERO;
        }

        return expression.execute();
    }
}
