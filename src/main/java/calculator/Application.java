package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;

import java.util.List;

public class Application {

    private static final InputView INPUT_VIEW = new InputView();

    public static void main(String[] args) {
        Calculator calculator = createCalculator();
        int result = calculator.doCalculations();
        System.out.println(result);
    }

    private static Calculator createCalculator() {
        try {
            List<String> formula = INPUT_VIEW.receiveFormula();
            return new Calculator(formula);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createCalculator();
        }
    }
}
