package step1;

public class StringArithmeticCalculator {

    public static void main(String[] args) {
        UserInput userInput = InputView.getUserInput();
        Expression expression = ExpressionParser.parse(userInput);

        while (expression.isNotCalculated()) {
            Operation operation = expression.getOperation();
            String operationResult = Calculator.calculate(operation);
            expression.addOperand(operationResult);
        }

        ResultView.printResult(expression.getCalculateResult());
    }
}
