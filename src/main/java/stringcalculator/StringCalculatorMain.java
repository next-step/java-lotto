package stringcalculator;

import domain.Number;
import domain.StringCalculator;
import ui.InputView;
import ui.ResultView;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String input = InputView.input();
        StringCalculator stringCalculator = new StringCalculator();
        Number number = stringCalculator.calculateString(input);
        ResultView.printResult(number.value());
    }
}
