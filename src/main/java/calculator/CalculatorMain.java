package calculator;

import calculator.controller.CalculatorController;
import view.InputView;
import view.OutputView;

public class CalculatorMain {

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(InputView.getInstance(), OutputView.getInstance());
        calculatorController.calculate();
    }
}
