package stringcalculator;

import stringcalculator.service.StringCalculatorService;
import stringcalculator.view.InputView;
import stringcalculator.view.OutputView;

public class StringCalculatorApplication {
    public static void main(String[] args) {
        int result = StringCalculatorService.runCalculator(InputView.inputString());
        OutputView.printOutput(result);
    }
}
