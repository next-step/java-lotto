package calculator.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorFilter {
    private static final String REGULAR_EXPRESSION = "//(.)\n(.*)";
    private static final String DEFAULT_REGEX = ",|:";
    private static final String DELIMETER_DIVIDER = "|";
    private static final int REGULAR_EXPRESSION_HEAD = 1;
    private static final int REGULAR_EXPRESSION_MESSAGE = 2;

    private static final String DEFAULT_VALUE = "0";

    private final String input;


    public StringCalculatorFilter(String input) {
        String checkedString = checkNullAndEmpty(input);
        this.input = checkedString;
    }

    public String messageFromString() {
        Matcher matcher = Pattern.compile(REGULAR_EXPRESSION).matcher(this.input);
        if (matcher.find()) {
            return matcher.group(REGULAR_EXPRESSION_MESSAGE);
        }
        return this.input;
    }

    public String regexFromString() {
        Matcher matcher = Pattern.compile(REGULAR_EXPRESSION).matcher(this.input);
        if (matcher.find()) {
            return addCustomRegex(matcher.group(REGULAR_EXPRESSION_HEAD));
        }
        return DEFAULT_REGEX;
    }

    private String addCustomRegex(String customRegex) {
        return String.join(DELIMETER_DIVIDER, DEFAULT_REGEX, customRegex);
    }

    private String checkNullAndEmpty(String input) {
        if (input == null || input.isEmpty() || input.trim() == "") {
            return DEFAULT_VALUE;
        }
        return input;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringCalculatorFilter that = (StringCalculatorFilter) o;
        return Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }
}
