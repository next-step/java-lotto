package StringCalculator;

import StringCalculator.domain.StringCalculator;
import StringCalculator.view.InputView;
import StringCalculator.view.OutputView;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String expression = InputView.Input();

        StringCalculator stringCalculator = new StringCalculator(expression);

        OutputView.output(stringCalculator.calculate());
    }
}
