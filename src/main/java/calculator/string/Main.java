package calculator.string;

import calculator.string.controller.CalculatorController;
import calculator.string.domain.StringCalculator;

public class Main {
    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController(new StringCalculator());
        controller.prepareCalculator();
        controller.executeCalculator();
    }
}
