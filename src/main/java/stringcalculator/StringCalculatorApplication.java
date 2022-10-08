package stringcalculator;

import java.util.List;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        List<String> input = InputView.getInput();
        int result = StringCalculator.calculate(input);
        ResultView.printResult(result);
    }
}
