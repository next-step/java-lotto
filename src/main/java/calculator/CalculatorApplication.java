package calculator;

import calculator.model.Calculator;
import calculator.model.CalculatorFactory;
import calculator.view.CalculatorView;

public class CalculatorApplication {
    public static void main(String[] args) {
        String expression = CalculatorView.readExpressionInput();
        Calculator calculator = CalculatorFactory.createCalculator(expression);
        CalculatorView.printResult(calculator.run());
    }
}
