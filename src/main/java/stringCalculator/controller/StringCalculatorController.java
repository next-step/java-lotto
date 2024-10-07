package stringCalculator.controller;

import stringCalculator.StringCalculatorService;
import stringCalculator.ui.StringCalculatorInputView;
import stringCalculator.ui.StringCalculatorOutputView;

import java.util.Arrays;
import java.util.List;

public class StringCalculatorController {
    private final StringCalculatorService stringCalculatorService;


    public StringCalculatorController() {
        this.stringCalculatorService = new StringCalculatorService();
    }

    public void run() {
        String expression = StringCalculatorInputView.getExpression();
        List<String> expressions = Arrays.asList(expression.split(" "));
        int result = stringCalculatorService.calculateExpressions(expressions);
        StringCalculatorOutputView.resultPrint(result);
    }


}
