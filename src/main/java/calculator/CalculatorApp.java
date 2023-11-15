package calculator;

import calculator.controller.CalculatorController;
import calculator.ui.InputView;
import calculator.ui.OutputView;

public class CalculatorApp {
    public static void main(String[] args) {
        String expression = InputView.inputExpression();

        CalculatorController controller = new CalculatorController(expression);
        int result = controller.calculate(expression);

        OutputView.outputResult(result);
    }
}
