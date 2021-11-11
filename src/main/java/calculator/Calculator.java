package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator implements Function<String, Integer> {
    private static final int NULL_OR_EMPTY_RESULT = 0;
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CHECK_CUSTOM_DELIMITER_USED = "//";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";

    @Override
    public Integer apply(String input) {
        if (isNullOrEmpty(input)) {
            return NULL_OR_EMPTY_RESULT;
        }

        if (input.startsWith(CHECK_CUSTOM_DELIMITER_USED)) {
            return applyCustomDelimiter(input);
        }

        return applyDefaultDelimiter(input);
    }

    private Integer applyDefaultDelimiter(String input) {
        final List<String> numbers = Arrays.stream(input.trim().split(DEFAULT_DELIMITER)).collect(Collectors.toList());
        return numbers.stream()
                .mapToInt(this::convertStringToInteger)
                .sum();
    }

    private int applyCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);

        isValidCustomPattern(matcher);

        String customDelimiter = getCustomDelimiter(matcher);

        final List<String > numbers = getNumbers(matcher, customDelimiter);
        if (numbers == null) return NULL_OR_EMPTY_RESULT;

        return numbers.stream()
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

    private List<String> getNumbers(Matcher matcher, String customDelimiter) {
        if (isNullOrEmpty(matcher.group(2).trim())) {
            return null;
        }

        return Arrays.stream(matcher.group(2).trim().split(customDelimiter)).collect(Collectors.toList());
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private int convertStringToInteger(String value) {
        final int target;

        try {
            target = Integer.parseInt(value);
        } catch (Exception e) {
            throw new RuntimeException("숫자 이외의 값을 입력으로 사용할 수 없습니다.");
        }

        if (target < 0) {
            throw new RuntimeException("숫자 이외의 값을 입력으로 사용할 수 없습니다.");
        }

        return target;
    }
}
