package calculator;

import calculator.domain.Calculator;
import calculator.domain.InputNumber;
import calculator.view.InputView;

public class CalculatorApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        InputNumber inputString = new InputNumber(inputView.inputStringAdditionCalculator());

        Calculator calculator = new Calculator(inputString);


    }
}
