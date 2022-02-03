package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final String NEW_LINE = "\n";
    private static final String DOUBLE_SLASH = "//";
    private static final String START_REGEX = "[";
    private static final String END_REGEX = "]";
    private static final int LIMIT_MINIMUM_NUMBER = 0;

    private final String operation;
    private final List<String> delimiters;

    public Parser(String text, List<String> delimiters) {
        this.operation = trimDelimiter(text);
        this.delimiters = new ArrayList<>(delimiters);
    }

    private String trimDelimiter(String text) {
        if (isCustomDelimiter(text)) {
            return text.split(NEW_LINE)[1];
        }
        return text;
    }

    private boolean isCustomDelimiter(String text) {
        return text.startsWith(DOUBLE_SLASH);
    }

    public List<Integer> splitNumbersByDelimiter() {
        final String regex = makeRegularExpression();
        endByDelimiter(regex);
        final String[] numbers = operation.split(regex);
        return castToInteger(numbers);
    }

    private void endByDelimiter(String regex) {
        if (operation.substring(operation.length() - 1).matches(regex)) {
            throw new RuntimeException("[ERROR] 숫자 이외의 값을 계산할 수 없습니다.");
        }
    }

    private List<Integer> castToInteger(String[] numbers) {
        try {
            return Arrays.stream(numbers)
                .map(value -> {
                    final Integer number = Integer.parseInt(value);
                    validPositiveNumber(number);
                    return number;
                }).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("[ERROR] 숫자 이외의 값을 계산할 수 없습니다.");
        }
    }

    private void validPositiveNumber(Integer value) {
        if (value < LIMIT_MINIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 음수 값은 입력할 수 없습니다.");
        }
    }

    private String makeRegularExpression() {
        return delimiters.stream()
            .reduce(START_REGEX, (origin, current) -> origin + current)
            + END_REGEX;
    }
}
