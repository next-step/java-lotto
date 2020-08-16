import common.ExceptionMessage;
import view.InputView;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String param = InputView.expressionValue();

        validateExpression(param);
        Delimiter delimiter = extractCustomDelimiter(param);
        param = extractExpression(param);
        ExpressionNumbers expressionValues = delimiter.splitValue(param);

        ExpressionNumber result = expressionValues.sum();

        System.out.println(result.getNumber());
    }

    private static String extractExpression(String param) {
        if (param.startsWith("//")) {
            return param.substring(4);
        }

        return param;
    }

    private static boolean validateExpression(String param) {
        if (ExpressionValidator.validExpression(param)) {
            return true;
        }

        throw new IllegalArgumentException(ExceptionMessage.WRONG_EXPRESSION.printMessage());
    }

    private static Delimiter extractCustomDelimiter(String expressionValue) {
        return Delimiter.newInstance(expressionValue);
    }
}
