package calculator;

import calculator.controller.StringCalculatorController;

public class StringCalculatorApplication {
    public static void main(String[] args) {
        StringCalculatorController controller = new StringCalculatorController();
        controller.start();
    }
}
