package calculator;

import calculator.controller.CalculatorControlller;

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculatorControlller calculatorControlller = new CalculatorControlller();
        calculatorControlller.start();
    }
}
