package calculator;

import calculator.controller.CalculatorController;
import calculator.ui.InputView;
import calculator.ui.InputViewImpl;
import calculator.ui.OutputViewImpl;

public class CalculatorApp {
    public static void main(String[] args) {
        InputView inputView = new InputViewImpl();
        String expression = inputView.inputExpression();

        CalculatorController controller = new CalculatorController(expression);
        int result = controller.calculate(expression);

        OutputViewImpl outputView = new OutputViewImpl();
        outputView.outputResult(result);
    }
}
