package stringcalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionParser {

    private static final String INVALID_EXPRESSION_FORMAT_EXCEPTION_MESSAGE = "구분자와 숫자만으로 이루어져야 합니다.";

    private String delimiters;

    public ExpressionParser(Delimiters delimiters) {
        this.delimiters = delimiters.getValuesToString();
    }

    public List<Integer> parse(String expression) {
        validateContainsOtherCharacter(expression);
        String[] split = expression.split(getDelimiterRegex());

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String getDelimiterRegex() {
        return String.format("[%s]", delimiters);
    }

    private void validateContainsOtherCharacter(String expression) {
        if (!expression.matches(getExpressionValidateRegex())) {
            throw new IllegalArgumentException(INVALID_EXPRESSION_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private String getExpressionValidateRegex() {
        return String.format("[0-9%s]+$", delimiters);
    }
}
