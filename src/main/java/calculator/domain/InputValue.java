package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValue {
    private static final String STRING_BLANK = "";
    private static final String REGULAR_EXPRESSION_ONLY_NUMBER = "^[0-9]*$";
    private static final String REGULAR_EXPRESSION_COMMA = ",";
    private static final String REGULAR_EXPRESSION_COMMA_OR_COLON = ",|:";
    private static final String REGULAR_EXPRESSION_CUSTOM = "//(.)\n(.*)";

    private String inputStringValue;
    private Matcher matcher;

    public InputValue(String inputStringValue) {
        this.inputStringValue = inputStringValue;
    }

    public String getInputStringValue() {
        return inputStringValue;
    }

    public boolean isNullOrBlank() {
        return inputStringValue == null || inputStringValue == STRING_BLANK;
    }

    public boolean isOneLengthOnlyNumber() {
        return isOnlyNumber() && isOneLength();
    }

    private boolean isOnlyNumber() {
        return inputStringValue.matches(REGULAR_EXPRESSION_ONLY_NUMBER);
    }

    private boolean isOneLength() {
        return inputStringValue.length() == 1;
    }

    public boolean isMoreThanTwoNumber() {
        return isOnlyNumber() && isMoreThanTwoLength();
    }

    private boolean isMoreThanTwoLength() {
        return inputStringValue.length() > 1;
    }

    public List<Integer> getSeparatedValuesByComma() {
        return getSeparatedValues(inputStringValue.split(REGULAR_EXPRESSION_COMMA));
    }

    private List<Integer> getSeparatedValues(String[] inputStringArray) {
        return Arrays.asList(inputStringArray).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean isCommaOrColonSeparator() {
        return isEffectiveSeparator(REGULAR_EXPRESSION_COMMA_OR_COLON);
    }

    private boolean isEffectiveSeparator(String regex) {
        matcher = Pattern.compile(regex).matcher(inputStringValue);
        return matcher.find();
    }

    public List<Integer> getSeparatedValuesByCommaOrColon() {
        return getSeparatedValues(inputStringValue.split(REGULAR_EXPRESSION_COMMA_OR_COLON));
    }

    public boolean isCustomSeparator() {
        Matcher matcher = getRegularExpressionCustomMatcher();
        return matcher.find();
    }

    public List<Integer> getSeparatedValuesByCustom() {
        String[] tokens = null;
        Matcher matcher = getRegularExpressionCustomMatcher();
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            tokens = matcher.group(2).split(customDelimiter);

        }

        return getSeparatedValues(tokens);
    }

    private Matcher getRegularExpressionCustomMatcher() {
        return Pattern.compile(REGULAR_EXPRESSION_CUSTOM).matcher(inputStringValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputValue that = (InputValue) o;
        return Objects.equals(inputStringValue, that.inputStringValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputStringValue);
    }
}
