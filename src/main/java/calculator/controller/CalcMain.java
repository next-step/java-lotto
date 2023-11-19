package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.domain.StringSplit;
import calculator.ui.InputView;
import calculator.ui.OutView;

public class CalcMain {

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(new StringSplit(InputView.inputString()).split());
        int result = stringCalculator.calculator2();
        OutView.printResult(result);
    }
}
