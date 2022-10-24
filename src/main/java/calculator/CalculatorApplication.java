package calculator;

import calculator.controller.CalculateController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApplication {
    public static void main(String[] args) {
        new CalculateController(new InputView(), new OutputView()).start();
    }
}
