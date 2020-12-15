package calculator;

import calculator.view.InputView;

public class CalculatorApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String inputString = inputView.inputStringAdditionCalculator();
        System.out.println("입력하신 문자열: " + inputString);
    }
}
