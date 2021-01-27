package calculator.string;

import calculator.string.controller.CalculatorController;

public class Main {
    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController();

        String ex = controller.prepareCalculator();

        int result = controller.executeCalculator(ex);

        controller.endCalculator(result);
    }
}
