package study2.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final PositiveNumbers numbers;

    public StringCalculator(String input) {
        numbers = PositiveNumbers.of(splitInput(parseEmptyToZero(input)));
    }

    private String parseEmptyToZero(String stringNumber) {
        if (stringNumber == null || stringNumber.trim().isEmpty()) {
            return "0";
        }
        return stringNumber;
    }

    private String[] splitInput(String input) {
        String separator = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
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
