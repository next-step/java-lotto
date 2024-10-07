package stringCalculator.controller;

import stringCalculator.StringCalculatorService;
import stringCalculator.ui.StringCalculatorInputView;
import stringCalculator.ui.StringCalculatorOutputView;

import java.util.List;

public class StringCalculatorController {
    private final StringCalculatorService stringCalculatorService;


    public StringCalculatorController() {
        this.stringCalculatorService = new StringCalculatorService();
    }

    public void run() {
        List<String> expressions = StringCalculatorInputView.getExpression();
        int result = stringCalculatorService.calculateExpressions(expressions);
        StringCalculatorOutputView.resultPrint(result);
    }


}
