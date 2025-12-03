import controller.Calculator;
import ui.InputView;
import ui.ResultView;
import util.Parser;

public class CalculatorApplication {
    public static void main(String[] args) {
        String expression = InputView.getExpression();
        Calculator calculator = Parser.parse(expression);

        ResultView.printResult(calculator.calculate().toString());
    }
}
