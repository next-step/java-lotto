package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        String input = InputView.readInput();
        String[] tokens = StringCalculator.split(input);
        StringCalculator.validateSequence(tokens);
        OutputView.printResult(StringCalculator.calculate(tokens));
    }
}
