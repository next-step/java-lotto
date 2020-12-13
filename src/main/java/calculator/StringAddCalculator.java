package calculator;

import calculator.domain.Expression;

class StringAddCalculator {
    public static int splitAndSum(String input) {
        Expression expression = new Expression(input);
        return expression.getOperands().sum();
    }
}
