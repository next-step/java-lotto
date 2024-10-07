package stringCalculator.controller;

import stringCalculator.StringCalculatorService;
import stringCalculator.ui.StringCalculatorInputView;
import stringCalculator.ui.StringCalculatorOutputView;

public class StringCalculatorController {
    private final StringCalculatorService stringCalculatorService;


    public StringCalculatorController() {
        this.stringCalculatorService = new StringCalculatorService();
    }

    public void run() {
        String expression = StringCalculatorInputView.getExpression();
        int result = stringCalculatorService.calculateExpressions(expression);
        StringCalculatorOutputView.resultPrint(result);
    }


}
