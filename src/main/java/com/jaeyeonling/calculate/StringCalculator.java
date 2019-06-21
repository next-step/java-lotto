package com.jaeyeonling.calculate;

final class StringCalculator {

    private StringCalculator() { }

    static int add(final String expression) {
        return Expression.execute(expression);
    }
}
