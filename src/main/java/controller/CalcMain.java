package controller;

import domain.StringCalculator;
import domain.StringSplit;
import ui.InputView;
import ui.OutView;

public class CalcMain {

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(new StringSplit(InputView.inputString()).split());
        int result = stringCalculator.calculator2();
        OutView.printResult(result);
    }
}
