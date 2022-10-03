package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = createCalculator();
        OutputView.printResult(calculator.doCalculations());
    }

    private static Calculator createCalculator() {
        try {
            List<String> formula = InputView.receiveFormula();
            return new Calculator(formula);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createCalculator();
        }
    }
}
