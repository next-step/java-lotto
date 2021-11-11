package calculator;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator implements Function<String, Integer> {
    private static final int NULL_OR_EMPTY_RESULT = 0;
    private static final String DEFAULT_DELIMITER = "[,:]";

    @Override
    public Integer apply(String input) {
        if (isNullOrEmpty(input)) {
            return NULL_OR_EMPTY_RESULT;
        }

        if (input.startsWith("//")) {
            return applyCustomDelimiter(input);
        }

        return applyDefaultDelimiter(input);
    }

    private Integer applyDefaultDelimiter(String input) {
        final String[] numbers = input.trim().split(DEFAULT_DELIMITER);
        return Arrays.stream(numbers)
                .mapToInt(this::convertStringToInteger)
                .sum();
    }

    private int applyCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(input);

        isValidCustomPattern(matcher);

        String customDelimiter = getCustomDelimiter(matcher);

        final String[] numbers = getNumbers(matcher, customDelimiter);
        if (numbers == null) return NULL_OR_EMPTY_RESULT;

        return Arrays.stream(numbers)
                .mapToInt(this::convertStringToInteger)
                .sum();
    }

    private void isValidCustomPattern(Matcher matcher) {
        if (!matcher.find()) {
            throw new RuntimeException("유효하지 않은 형식입니다.");
        }
    }

    private String getCustomDelimiter(Matcher matcher) {
        return matcher.group(1);
    }

    private String[] getNumbers(Matcher matcher, String customDelimiter) {
        if (isNullOrEmpty(matcher.group(2).trim())) {
            return null;
        }

        return matcher.group(2).trim().split(customDelimiter);
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private int convertStringToInteger(String value) {
        for (int i = 0; i < value.length(); i++) {
            isNumberOrElseThrow(value.charAt(i));
        }
        return Integer.parseInt(value);
    }

    private void isNumberOrElseThrow(char target) {
        if (target < '0' || target > '9') {
            throw new RuntimeException("숫자 이외의 값 또는 음수를 입력으로 사용할 수 없습니다.");
        }
    }
}
