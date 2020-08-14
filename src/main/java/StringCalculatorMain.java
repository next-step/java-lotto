import common.ExceptionMessage;
import view.InputView;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String param = InputView.expressionValue();
        String delimiter = "[,:]";

        validateExpression(param);
        delimiter = extractCustomDelimiter(param, delimiter);
        param = extractExpression(param);
        String[] expressionValues = splitValues(param, delimiter);

        int result = add(expressionValues);

        System.out.println(result);
    }

    private static Integer add(String[] expressionValues) {
        return Arrays.stream(expressionValues).map(value -> Integer.parseInt(value))
                .reduce((number1, number2) -> number1 + number2)
                .get();
    }

    private static String[] splitValues(String param, String delimiter) {
        String[] split = param.split(delimiter);

        //validation
        validationNumber(split);

        return split;
    }

    private static void validationNumber(String[] split) {
        Arrays.stream(split)
                .forEach(number -> {
                    if (!Pattern.matches("[0-9]", number)) {
                        throw new IllegalArgumentException("숫자가 아닌 값을 입력하셨습니다.");
                    }

                    if (Integer.parseInt(number) < 0) {
                        throw new IllegalArgumentException("0보다 큰 값을 입력해주세요.");
                    }
                });
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
