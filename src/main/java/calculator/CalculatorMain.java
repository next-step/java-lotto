package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;

public class CalculatorMain {
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        Calculator calculator = new Calculator(inputView.getInputString());
        calculator.run();

    }
}
