package calculator;

import calculator.controller.Calculator;
import calculator.model.Formula;
import calculator.view.InputView;

public class CalculatorApplication {
    public static void main(String[] args) {
        new CalculatorApplication().run(args);
    }

    private void run(String[] args) {
        Formula formula = InputView.getFormula();
        Calculator calculator = new Calculator();
        calculator.calculate(formula);
    }
}
