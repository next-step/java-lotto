package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorMain {

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(InputView.getInstance(), OutputView.getInstance());
        calculatorController.calculate();
    }
}
