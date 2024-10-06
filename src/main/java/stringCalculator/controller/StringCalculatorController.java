package stringCalculator.controller;

import stringCalculator.StringCalculatorService;
import stringCalculator.ui.StringCalculatorInputView;
import stringCalculator.ui.StringCalculatorOutputView;

import java.util.List;

public class StringCalculatorController {
    private final StringCalculatorInputView inputView;
    private final StringCalculatorOutputView outputView;
    private final StringCalculatorService stringCalculatorService;


    public StringCalculatorController() {
        this.inputView = new StringCalculatorInputView();
        this.outputView = new StringCalculatorOutputView();
        this.stringCalculatorService = new StringCalculatorService();
    }

    public void run() {
        List<String> expressions = inputView.getExpression();
        int result = stringCalculatorService.calculateExpressions(expressions);
        outputView.resultPrint(result);
    }


}
