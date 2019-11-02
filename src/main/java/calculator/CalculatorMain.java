package calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        String input = InputView.getInput();

        StringCalculate stringCalculate = new StringCalculate();
        int result = stringCalculate.add(input);

        OutputView.printResult(result);
    }
}
