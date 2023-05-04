package calculator;

public class StringCalculator {
    public static void main(String[] args) {
        String inputExpression = InputView.inputExpression();
        Expression expression = ExpressionParser.parse(inputExpression);
        Number result = expression.calculate();
        ResultView.printResult(result);
    }

}
