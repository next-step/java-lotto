package calculator;

import calculator.domain.Calculation;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    public static void main(String[] arguments) throws Exception {
        try {
            String mathematicalExpression = InputView.enteredMathematicalExpression();

            Calculation calculation = new Calculation();
            double result = calculation.calculate(mathematicalExpression);

            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
