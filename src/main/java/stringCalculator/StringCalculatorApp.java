package stringCalculator;

import stringCalculator.domain.StringCalculator;
import stringCalculator.view.InputView;
import stringCalculator.view.ResultView;

public class StringCalculatorApp {
    public static void main(String[] args) {
        ResultView.printResult(StringCalculator.from(InputView.inputExpression()).calculate());
    }
}
