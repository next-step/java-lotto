package dev.dahye.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private final List<String> numbers;

    public Numbers(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        String delimiter = DEFAULT_DELIMITER;

        if (m.find()) {
            delimiter = m.group(1);
            input = m.group(2);
        }

        this.numbers = Arrays.asList(input.split(delimiter));
    }

    public int sum() {
        int result = 0;

        for (String number : numbers) {
            result += getValidNumber(number);
        }

        return result;
    }

    private int getValidNumber(String stringNumber) {
        try {
            int number = Integer.parseInt(stringNumber);
            validateMinus(number);

            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값은 계산할 수 없습니다.", e);
        }
    }

    private void validateMinus(int number) {
        if (number < 0) {
            throw new RuntimeException("음수를 계산할 수 없습니다.");
        }
    }
}
