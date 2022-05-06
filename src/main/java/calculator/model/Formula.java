package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formula {
    private static final String CALCULATION_STRING_PATTERN = "^\\d( [-+*/] \\d)+$";
    private static final Pattern CALCULATION_PATTERN = Pattern.compile(CALCULATION_STRING_PATTERN);

    private static final String EMPTY_INPUT_STRING = "빈 문자열은 처리할 수 없습니다.";
    private static final String NOT_MATCHED_PATTERN = "문자 규칙을 확인해주세요. 입력 문자 : %s";

    private final String formula;

    public Formula(String formula) {
        validate(formula);
        this.formula = formula;
    }

    private void validate(String inputText) {
        validateInputText(inputText);
        validateCalculatorPattern(inputText);
    }

    private void validateInputText(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_STRING);
        }
    }

    private void validateCalculatorPattern(String inputText) {
        Matcher calculatorMatcher = CALCULATION_PATTERN.matcher(inputText);
        if (!calculatorMatcher.find()) {
            throw new IllegalStateException(String.format(NOT_MATCHED_PATTERN, inputText));
        }
    }

    public String[] split(String delimiter) {
        return this.formula.split(delimiter);
    }
}
