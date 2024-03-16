package calculator;

import calculator.domain.Calculation;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    public static void main(String[] arguments) throws Exception {
        try {
            String mathematicalExpression = InputView.enteredMathematicalExpression();

            Calculation calculation = Calculation.newCalculation(mathematicalExpression);
            double result = calculation.calculate();

            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
