package calculator;

public class StringCalculatorApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        StringCalculatorView stringCalculatorView = new StringCalculatorView();
        Expression expression = Expression.fromString(stringCalculatorView.getStringInputFromConsole());
        stringCalculatorView.printToConsole(calculator.evaluate(expression));
    }
}
