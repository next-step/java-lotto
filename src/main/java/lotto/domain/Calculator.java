package lotto.domain;

import lotto.util.OperationStrategyFactory;

public class Calculator {

    private final Expression expression;

    public Calculator(Expression expression) {
        this.expression = expression;
    }

    public int calculate() {
        int number = expression.getNumber();
        while (!expression.getOperators().isEmpty()) {
            String operator = expression.getOperator();
            int nextNumber = expression.getNumber();
            number = calculate(operator, number, nextNumber);
        }

        return number;
    }

    private int calculate(String operator, int number1, int number2) {
        OperationStrategy operation = OperationStrategyFactory.getStrategy(operator);
        return operation.calculate(number1, number2);
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }
}
