package stringcalculator.controller;

import stringcalculator.model.Calculator;
import stringcalculator.view.InputView;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String userInput = InputView.userInput();
        Calculator cal = new Calculator(userInput);
        int result = cal.calculate();
        System.out.println(result);
    }
}
