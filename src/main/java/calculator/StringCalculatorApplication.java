package calculator;

import calculator.controller.CalculatorManager;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        CalculatorManager calculator = new CalculatorManager();
        calculator.start();
    }
}
