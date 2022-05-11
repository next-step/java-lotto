package stringCalculator;

import stringCalculator.domains.StringCalculator;
import stringCalculator.views.InputView;
import stringCalculator.views.ResultView;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String input = InputView.askInputExpression();
        ResultView.printCalculationResult(StringCalculator.calculate(input));
    }
}
