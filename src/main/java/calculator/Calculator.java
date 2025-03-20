package calculator;

import calculator.expression.Expression;

public class Calculator {

    private final Expression expression;

    public Calculator(String input) {
        this.expression = Expression.of(input);
    }

    public int calculate() {
        return expression.calculate();
    }

}
