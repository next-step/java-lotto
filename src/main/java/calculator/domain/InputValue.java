package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValue {
    private static final String STRING_BLANK = "";
    private static final String REGULAR_EXPRESSION_ONLY_NUMBER = "^[0-9]*$";
    private static final String REGULAR_EXPRESSION_COMMA = ",";
    private static final String REGULAR_EXPRESSION_COMMA_OR_COLON = ",|:";

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

    public boolean isCommaSeparator() {
        return isEffectiveSeparator(REGULAR_EXPRESSION_COMMA);
    }

    public boolean isMoreThanTwoNumber() {
        return isOnlyNumber() && isMoreThanTwoLength();
    }

    private boolean isMoreThanTwoLength() {
        return inputStringValue.length() > 1;
    }

    public List<String> getSeparatedValuesByComma() {
        return getSeparatedValues(REGULAR_EXPRESSION_COMMA);
    }

    private List<String> getSeparatedValues(String regex) {
        return Arrays.asList(inputStringValue.split(regex));
    }

    public boolean isCommaOrColonSeparator() {
        return isEffectiveSeparator(REGULAR_EXPRESSION_COMMA_OR_COLON);
    }

    private boolean isEffectiveSeparator(String regex) {
        matcher = Pattern.compile(regex).matcher(inputStringValue);
        return matcher.find();
    }

    public List<String> getSeparatedValuesByCommaOrColon() {
        return getSeparatedValues(REGULAR_EXPRESSION_COMMA_OR_COLON);
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
