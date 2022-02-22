package calculator;

import calculator.controller.CalculatorController;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController();
        controller.start();
    }
}
