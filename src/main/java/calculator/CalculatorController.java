package calculator;

import calculator.view.InputView;

public class CalculatorController {

    public static void main(String[] args) {
        String inputString = InputView.getString();
        System.out.println(inputString);
    }
}
