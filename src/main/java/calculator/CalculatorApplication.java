package calculator;

public class CalculatorApplication {
    public static void main(String[] args) {
        String text = InputView.requestInput();
        int result = StringAddCalculator.splitAndSum(text);
        OutputView.showResult(result);
    }
}
