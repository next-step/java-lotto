package calculator.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberExtractor {

    private static final String NEW_LINE = "\n";
    private static final String DOUBLE_SLASH = "//";
    private static final String START_REGEX = "[";
    private static final String END_REGEX = "]";
    private static final int LIMIT_MINIMUM_NUMBER = 0;

    private NumberExtractor() {
    }

    private static String trimDelimiter(String text) {
        if (isCustomDelimiter(text)) {
            return text.split(NEW_LINE)[1];
        }
        return text;
    }

    private static boolean isCustomDelimiter(String text) {
        return text.startsWith(DOUBLE_SLASH);
    }

    public static List<Integer> splitNumbersByDelimiter(String text, List<String> delimiters) {
        if (text.isEmpty()) {
            return new ArrayList<>();
        }
        final String operation = trimDelimiter(text);
        final String regex = makeRegularExpression(delimiters);
        endByDelimiter(operation, regex);
        final String[] numbers = operation.split(regex);
        return castToInteger(numbers);
    }

    private static void endByDelimiter(String operation, String regex) {
        if (operation.substring(operation.length() - 1).matches(regex)) {
            throw new RuntimeException("[ERROR] 숫자 이외의 값을 계산할 수 없습니다.");
        }
    }

    private static List<Integer> castToInteger(String[] numbers) {
        try {
            return Arrays.stream(numbers).map(value -> {
                final Integer number = Integer.parseInt(value);
                validPositiveNumber(number);
                return number;
            }).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("[ERROR] 숫자 이외의 값을 계산할 수 없습니다.");
        }
    }

    private static void validPositiveNumber(Integer value) {
        if (value < LIMIT_MINIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 음수 값은 입력할 수 없습니다.");
        }
    }

    private static String makeRegularExpression(List<String> delimiters) {
        return delimiters.stream().reduce(START_REGEX, (origin, value) -> origin + value)
            + END_REGEX;
    }
}
