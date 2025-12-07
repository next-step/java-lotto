import controller.Calculator;
import ui.InputView;
import ui.ResultView;

public class CalculatorApplication {
    public static void main(String[] args) {
        String expression = InputView.getExpression();
        Calculator calculator = new Calculator(expression);

        ResultView.printResult(calculator.calculate().toString());
    }
}
