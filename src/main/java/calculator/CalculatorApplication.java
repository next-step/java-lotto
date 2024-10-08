package calculator;

import calculator.config.CalculatorConfig;
import calculator.controller.CalculatorController;

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculatorController calculatorController = CalculatorConfig.calculatorController();
        calculatorController.run();
    }
}
