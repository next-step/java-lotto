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
            result = operate(result, Operator.valueOfSymbol(parsedExpression[i]), Integer.parseInt(parsedExpression[i+1]));
        }
        return result;
    }

    private static int operate(int result, Operator operator, int number) {
        switch (operator) {
            case ADD:
                return Calculator.add(result, number);
            case SUBTRACT:
                return Calculator.subtract(result, number);
            case MULTIPLY:
                return Calculator.multiply(result, number);
            case DIVIDE:
                return Calculator.divide(result, number);
            default:
                throw new IllegalArgumentException("지원되지 않는 연산자입니다: " + operator);
        }
    }
}