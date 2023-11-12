package calculator;

import calculator.controller.CalculatorController;
import calculator.ui.InputView;
import calculator.ui.InputViewImpl;

public class CalculatorApp {
    public static void main(String[] args) {
        InputView inputView = new InputViewImpl();
        String expression = inputView.inputExpression();
        CalculatorController controller = new CalculatorController();
        controller.calculate(expression);
    }
}
