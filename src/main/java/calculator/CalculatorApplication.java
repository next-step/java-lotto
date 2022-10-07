package calculator;

import calculator.controller.CalculatorController;

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculatorController calculatorControlller = new CalculatorController();
        calculatorControlller.start();
    }
}
