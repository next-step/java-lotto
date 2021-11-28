package calculator.controller;

import calculator.domain.Expression;

public class StringCalculator {

    private static final StringCalculator INSTANCE = new StringCalculator();

    private StringCalculator() {

    }

    public static StringCalculator getInstance() {
        return INSTANCE;
    }

    public int execute(String expression) {
        return calculate(Expression.of(expression));
    }

    private int calculate(Expression expression) {
        return expression.calculate();
    }
}
