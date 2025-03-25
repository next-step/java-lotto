package calculator;

import calculator.ui.InputView;
import calculator.ui.OutputView;

public class Main {

    public static void main(String[] args) {
        String input = InputView.get();

        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(input);

        OutputView.printResult(result);
    }
}
