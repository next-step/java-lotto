package study2.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String EMPTY_NUMBER = "0";
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

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
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR).matcher(input);
        if (m.find()) {
            separator = m.group(1);
            return m.group(2).split(separator);
        }
        return input.split(separator);
    }

    public int sum() {
        return numbers.sum();
    }
}
