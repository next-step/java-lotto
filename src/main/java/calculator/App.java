package calculator;

public class App {
    public static void main(String[] args) {
        String input = InputView.inputExpression();

        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(input);

        ResultView.printResult(input, result);
    }
}
