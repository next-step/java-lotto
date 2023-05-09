package stringcalculator.stringcalculator;

import stringcalculator.domain.Number;
import stringcalculator.domain.StringCalculator;
import stringcalculator.ui.InputView;
import stringcalculator.ui.ResultView;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String input = InputView.input();
        StringCalculator stringCalculator = new StringCalculator();
        Number number = stringCalculator.calculateString(input);
        ResultView.printResult(number.value());
    }
}
