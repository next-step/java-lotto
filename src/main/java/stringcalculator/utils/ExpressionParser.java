package stringcalculator.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionParser {

    private ExpressionParser() {
    }

    private static final String INVALID_EXPRESSION_FORMAT_EXCEPTION_MESSAGE = "구분자와 숫자만으로 이루어져야 합니다.";

    public static List<Integer> parse(String expression, String delimiters) {
        validateContainsOtherCharacter(expression, delimiters);
        String[] split = expression.split(delimiters);

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateContainsOtherCharacter(String expression, String delimiters) {
        if (!expression.matches(getExpressionValidateRegex(delimiters))) {
            throw new IllegalArgumentException(INVALID_EXPRESSION_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static String getExpressionValidateRegex(String delimiters) {
        return String.format("[0-9%s]+$", delimiters);
    }
}
