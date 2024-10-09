package calculator;

public class StringCalculatorMain {

    public static void main(String[] args) {
        String input = InputView.getInput();
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculator(input);
        OutputView.printResult(result);

    }
}
