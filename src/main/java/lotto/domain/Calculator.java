package lotto.domain;

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

    public int calculate(String operator, int number1, int number2) {
        if (expression.isAddSign(operator)) {
            return add(number1, number2);
        }
        if (expression.isSubtractSign(operator)) {
            return subtract(number1, number2);
        }
        if (expression.isMultiplySign(operator)) {
            return multiply(number1, number2);
        }
        return divide(number1, number2);
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
