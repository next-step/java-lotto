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

    private int calculate(String operator, int number1, int number2) {
        OperationStrategy operation = Operator.getStrategy(operator);
        return operation.calculate(number1, number2);
    }

}
