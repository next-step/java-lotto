package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        String input = InputView.readInput();
        int result = StringCalculator.calculate(Parser.parse(input));
        OutputView.printResult(result);
    }
}
