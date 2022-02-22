package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void start() {
        StringCalculator stringCalculator = getCalculator();
        int result = stringCalculator.sumNumbers();
        OutputView.printResult(result);
    }

    private StringCalculator getCalculator() {
        try {
            return StringCalculator.of(InputView.getUserInput());
        } catch (RuntimeException e) {
            e.printStackTrace();
            return getCalculator();
        }
    }
}
