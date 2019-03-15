package calculator;

import calculator.domain.Calculator;
import calculator.view.CalculatorView;

public class ConsoleApplication {
    public static void main(String[] args) {
        doCalculator();

    }

    private static void doCalculator() {
        try {
            String value = CalculatorView.getInputValue();

            CalculatorView.isBlankOrNull(value);

            String[] splitValues = CalculatorView.splitInputValue(value, CalculatorView.checkCustomSeparator(value));
            int result = Calculator.sum(splitValues);

            System.out.println(result);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

