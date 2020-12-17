package calculator;

import calculator.domain.Expression;

class StringAddCalculator {

    private StringAddCalculator() {
        throw new AssertionError();
    }

    public static int splitAndSum(String input) {
        Expression expression = new Expression(input);
        return expression.sum();
    }
}
