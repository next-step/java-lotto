package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {
    private static final String NOT_VALID_ARGUMENT_EXIST_STATEMENT = "음수 또는 숫자이외 값이 존재합니다";

    public String[] splitWithCommaOrColon(String expression) {
        return expression.split(",|:");
    }

    public String[] splitWithCustomDelimiter(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        return splitWithCommaOrColon(expression);
    }

    private static boolean isNaturalNumber(String expression) {
        Pattern pattern = Pattern.compile("\\d+");
        return pattern.matcher(expression).matches();
    }

    private static boolean isNullOrEmpty(String expression) {
        return Objects.isNull(expression) || "".equals(expression);
    }

    private static boolean containsNaturalNumber(String[] expressions) {
        return Arrays.asList(expressions)
                .stream()
                .anyMatch(token -> !isNaturalNumber(token));
    }

    public int splitAndSum(String expression) {
        if (isNullOrEmpty(expression)) return 0;
        if (isNaturalNumber(expression)) Integer.parseInt(expression);

        String[] tokens = splitWithCustomDelimiter(expression);
        if (containsNaturalNumber(tokens)) throw new RuntimeException(NOT_VALID_ARGUMENT_EXIST_STATEMENT);

        return Arrays.asList(tokens)
                .stream()
                .map(Integer::parseInt)
                .reduce(0, (firstOperand, secondOperand) -> firstOperand + secondOperand);
    }
}
