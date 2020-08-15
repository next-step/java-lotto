import common.ExceptionMessage;
import view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String param = InputView.expressionValue();
        String delimiter = "[,:]";

        validateExpression(param);
        delimiter = extractCustomDelimiter(param, delimiter);
        param = extractExpression(param);
        List<ExpressionNumber> expressionValues = splitValues(param, delimiter);

        ExpressionNumber result = add(expressionValues);

        System.out.println(result.getNumber());
    }

    private static ExpressionNumber add(List<ExpressionNumber> expressionValues) {
        return expressionValues.stream()
                .reduce((x, y) -> x.add(y))
                .get();
    }

    private static List<ExpressionNumber> splitValues(String param, String delimiter) {
        String[] split = param.split(delimiter);

        return Arrays.stream(split)
                .map(numberValue -> ExpressionNumber.newInstance(numberValue))
                .collect(Collectors.toList());
    }

    private static String extractExpression(String param) {
        if (param.startsWith("//")) {
            return param.substring(5);
        }

        return param;
    }

    private static String extractCustomDelimiter(String param, String delimiter) {
        if (param.startsWith("//")) {
            delimiter = param.substring(2, 3);
        }

        return delimiter;
    }

    private static boolean validateExpression(String param) {
        if (ExpressionValidator.validExpression(param)) {
            return true;
        }

        throw new IllegalArgumentException(ExceptionMessage.WRONG_EXPRESSION.printMessage());
    }
}
