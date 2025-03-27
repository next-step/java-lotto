import view.InputView;
import view.OutputView;

public class CalculatorApplication {

    public static void main(String[] args) {

        String expression = InputView.showExpressionInput();
        String[] parsedExpression = ExpressionParser.parse(expression);
        OutputView.showResult(calculate(parsedExpression));
    }

    private static int calculate(String[] parsedExpression) {
        int result = Integer.parseInt(parsedExpression[0]);
        for (int i = 1; i < parsedExpression.length - 1; i += 2) {
            result = Operator.valueOfSymbol(parsedExpression[i]).formula.apply(result, Integer.parseInt(parsedExpression[i + 1]));
        }
        return result;
    }
}
