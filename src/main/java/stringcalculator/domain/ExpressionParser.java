package stringcalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionParser {

    private static final String EMPTY_STRING = "";
    private String delimiters;

    public ExpressionParser(Delimiters delimiters) {
        this.delimiters = joinDelimiterWithEmptyString(delimiters.getValues());
    }

    private String joinDelimiterWithEmptyString(List<String> delimiters) {
        return String.join(EMPTY_STRING, delimiters);
    }

    public List<Integer> parse(String expression) {
        String regex = getSplitRegex();
        validateContainsCharacter(expression);
        String[] split = expression.split(regex);

        return Arrays.stream(split)
            .map((Integer::parseInt))
            .collect(Collectors.toList());
    }

    private String getSplitRegex() {
        return String.format("[%s]", delimiters);
    }

    private void validateContainsCharacter(String expression) {
        String regex = getValidateRegex();

        if (!expression.matches(regex)) {
            throw new IllegalArgumentException("구분자와 숫자만으로 이루어져야 합니다.");
        }
    }

    private String getValidateRegex() {
        return String.format("[0-9%s]+$", delimiters);
    }
}
