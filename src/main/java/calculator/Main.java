package calculator;

public class Main {
    public static void main(String[] args) {
        String expression = InputView.readExpression();
        int result = Calculator.calculate(expression);
        ResultView.printResult(result);

    }
}
