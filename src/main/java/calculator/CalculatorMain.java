package calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        String input = InputView.getInput();

        int result = StringCalculate.add(input);

        OutputView.printResult(result);
    }
}
