import common.ExceptionMessage;
import view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String param = InputView.expressionValue();

        validateExpression(param);
        Delimiter delimiter = extractCustomDelimiter(param);
        param = extractExpression(param);
        List<ExpressionNumber> expressionValues = splitValues(param, delimiter);

        ExpressionNumber result = add(expressionValues);

        System.out.println(result.getNumber());
    }

    private static ExpressionNumber add(List<ExpressionNumber> expressionValues) {
        ExpressionNumber expressionNumber = ExpressionNumber.newInstance();
        for (ExpressionNumber expressionValue : expressionValues) {
            expressionNumber.add(expressionValue);
        }

        return expressionNumber;
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


    private static List<ExpressionNumber> splitValues(String param, Delimiter delimiter) {
        String[] split = param.split(delimiter.pattern());

        return Arrays.stream(split)
                .map(numberValue -> ExpressionNumber.newInstance(numberValue))
                .collect(Collectors.toList());
    }

    private static Delimiter extractCustomDelimiter(String expressionValue) {
        return Delimiter.newInstance(expressionValue);
    }
}
