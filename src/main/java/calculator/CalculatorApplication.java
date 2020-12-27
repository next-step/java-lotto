package calculator;

import calculator.domain.StringAddCalculator;
import calculator.view.InputView;

public class CalculatorApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int result = StringAddCalculator.splitAndSum(inputView.inputStringAdditionCalculator());
        System.out.printf("Result: %d\n", result);
    }
}
