package stringcalculator.contorller;

import stringcalculator.domain.StringCalculator;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculatorController {
    public static void main(String[] args) {
        String text = InputView.inputView();
        StringCalculator stringCalculator = new StringCalculator();
        ResultView.result(stringCalculator.calculate(text));
    }
}
