package calculator.domain;

public class Calculator {

    public static int calculate(Expression expression) {
        int number = expression.getNumber().get();
        while (expression.hasOperator()) {
            String operator = expression.getOperator().get();
            int nextNumber = expression.getNumber().get();
            number = calculate(operator, number, nextNumber);
        }

        return number;
    }

    private static int calculate(String operator, int number1, int number2) {
        OperationStrategy operation = OperatorType.getStrategy(operator);
        return operation.calculate(number1, number2);
    }

}
