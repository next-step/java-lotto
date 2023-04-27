package domain;

import view.InputView;

public class StringCalculatorMain {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        StringCalculator stringCalculator = new StringCalculator();

        stringCalculator.readExpression(inputView.readExpression());
        int result = stringCalculator.calculate();

        System.out.println(">>> " + result);
    }
}
