package study2.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String EMPTY_NUMBER = "0";
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final int PATTERN_SEPARATOR_NUMBER = 1;
    private static final int PATTERN_MATCH_NUMBER = 2;

    private static final Pattern customPattern = Pattern.compile("//(.)\n(.*)");


    private final PositiveNumbers numbers;

    public StringCalculator(String input) {
        numbers = PositiveNumbers.of(splitInput(parseEmptyToZero(input)));
    }

    private String parseEmptyToZero(String stringNumber) {
        if (stringNumber == null || stringNumber.trim().isEmpty()) {
            return EMPTY_NUMBER;
        }
        return stringNumber;
    }

    private String[] splitInput(String input) {
        String separator = DEFAULT_SEPARATOR;
        Matcher m = customPattern.matcher(input);
        if (m.find()) {
            separator = m.group(PATTERN_SEPARATOR_NUMBER);
            return m.group(PATTERN_MATCH_NUMBER).split(separator);
        }
        return input.split(separator);
    }

    public int sum() {
        return numbers.sum();
    }
}
