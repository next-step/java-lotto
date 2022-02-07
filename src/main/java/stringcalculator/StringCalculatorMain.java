package stringcalculator;

import stringcalculator.domain.StringCalculator;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculatorMain {

    public static void main(String[] args) {
        String input = InputView.getExpression();
        int result = StringCalculator.add(input);
        ResultView.printResult(result);
    }
}
