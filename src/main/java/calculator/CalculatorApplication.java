package calculator;

import calculator.domain.StringAddCalculator;
import calculator.domain.InputNumber;
import calculator.view.InputView;

public class CalculatorApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        InputNumber inputString = new InputNumber(inputView.inputStringAdditionCalculator());

        StringAddCalculator calculator = new StringAddCalculator(inputString);


    }
}
