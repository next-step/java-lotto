package calculator;

public class StringCalculatorMain {

    public static void main(String[] args) {
        String input = InputView.getInput();
        int result = 0;

        try {
            StringCalculator calculator = new StringCalculator();
            result = calculator.calculator(input);
            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
