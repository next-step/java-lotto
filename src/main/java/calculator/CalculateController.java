package calculator;

public class CalculateController {
    public static void main(String[] args) {
        String input = new InputView().getInput();
        Expression expression = StringAdditionExpression.getExpression(input);
        int sum = Calculator.getInstance()
                .calculate(expression);

        new PrintView().print(sum);
    }
}
