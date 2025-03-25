import step1.util.InputView;
import step1.util.OutputView;
import step1.Expression;

public class Main {
    public static void main(String[] args) {
        String input = InputView.inputExpression();
        Expression expression = new Expression(input);
        OutputView.printResult(expression.calc());
    }
}