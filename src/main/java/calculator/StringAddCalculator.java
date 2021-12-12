package calculator;

import calculator.domain.Expression;

class StringAddCalculator {

    private StringAddCalculator() {
        throw new AssertionError();
    }

    public static int sum(String expression) {
        return new Expression(expression).sum();
    }
}
