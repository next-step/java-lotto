package step1;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formula {
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String DEFAULT_REGEX = ",:";
    private static final int CUSTOM_FORMULA_REGEX_INDEX = 1;
    private static final int CUSTOM_FORMULA_INDEX = 2;
    private static final int NUMBER_ZERO = 0;
    private static final String CUSTOM_REGEX_PATTERN = "//(.)\n(.*)";
    private static final String BLANK = "";

    private String formula;

    public Formula(String formula) {
        this.formula = formula;
    }

    public String getFormula() {
        return formula;
    }

    public String[] split() {
        if (isEmpty()) return new String[]{};
        Matcher matcher = Pattern.compile(CUSTOM_REGEX_PATTERN).matcher(formula);
        String customRegex = BLANK;
        if (matcher.find()) {
            customRegex = matcher.group(CUSTOM_FORMULA_REGEX_INDEX);
            formula = matcher.group(CUSTOM_FORMULA_INDEX);
        }
        return formula.split(LEFT_SQUARE_BRACKET + DEFAULT_REGEX + customRegex + RIGHT_SQUARE_BRACKET);
    }

    public int calculate() {
        String[] splitFormula = split();
        if (splitFormula.length == NUMBER_ZERO) return NUMBER_ZERO;
        return Arrays.stream(splitFormula).mapToInt((operand) -> {
            validateIsDigit(operand);
            return Integer.parseInt(operand);
        }).sum();
    }

    private void validateIsDigit(String operator) {
        boolean isDigit = operator.chars().allMatch(Character::isDigit);
        if (!isDigit) {
            throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다.");
        }
    }

    private boolean isEmpty() {
        return Objects.isNull(formula) || BLANK.equals(formula);
    }
}
