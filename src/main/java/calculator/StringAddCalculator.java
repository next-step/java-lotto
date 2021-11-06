package calculator;

import calculator.domain.Expression;

class StringAddCalculator {
    public static int sum(String expression) {
        return new Expression(expression).sum();
    }
}
