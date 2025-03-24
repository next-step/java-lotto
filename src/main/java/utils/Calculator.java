package utils;

import domain.Expression;

public class Calculator {
    public static int calculate(String input) {
        Expression expression = new Expression(input);
        return expression.evaluate();
    }
}
