package stringcalculator;

import stringcalculator.domain.StringCalculator;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculatorController {

    public static void main(String[] args) {
        String string = InputView.requestCalcInfo();

        StringCalculator stringCalculator = new StringCalculator(string);
        int result = stringCalculator.calculate();

        ResultView.printResult(result);
    }
}
