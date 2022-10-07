package stringcalculator;

import java.util.List;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        List<String> input = InputView.getInput();
        StringCalculator stringCalculator = new StringCalculator(input);
        int result = stringCalculator.calculate();
        ResultView.printResult(result);
    }
}
