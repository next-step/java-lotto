package calculator.controller;

import calculator.service.Calculator;
import calculator.service.ValidationCheck;
import calculator.view.InputView;
import calculator.view.ResultView;

public class StringCalculatorController {
    public static void main(String[] args) {
        String inputString = InputView.inputString();
        ValidationCheck.checkInputString(inputString);

        int result = Calculator.getResult(inputString.split(" "));
        ResultView.printResult(result);
    }
}
