package caculator.controller;

import caculator.domain.StringCalculator;
import caculator.view.InputView;

public class StringCalculatorMain {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.playCalculate(InputView.inputString()));
    }
}
