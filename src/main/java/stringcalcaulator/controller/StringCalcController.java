package stringcalcaulator.controller;

import stringcalcaulator.domain.StringCalculator;
import stringcalcaulator.view.StringCalculatorInputView;
import stringcalcaulator.view.StringCalculatorResultView;

public class StringCalcController {

    private final StringCalculatorInputView inputView = new StringCalculatorInputView();
    private final StringCalculatorResultView resultView = new StringCalculatorResultView();
    private final StringCalculator calculator = new StringCalculator();

    public void run() {
        String expression = inputView.getInput();

        int result = calculator.calculate(expression);

        resultView.printResult(result);
    }
}
