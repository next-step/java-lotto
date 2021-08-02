package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private static final String ZERO_OR_POSITIVE_NUMBER_PATTERN = "^[0-9]+$";
    private static final int INITIAL_SUM_VALUE = 0;

    private final List<Integer> numbers;

    static Numbers of(String[] numbers) {
        return new Numbers(numbers);
    }

    private Numbers(String[] numbers) {
        validateZeroOrPositiveNumber(numbers);
        this.numbers = Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static void validateZeroOrPositiveNumber(String[] numbers) {
        for (String number : numbers) {
            validateZeroOrPositiveNumber(number);
        }
    }

    private static void validateZeroOrPositiveNumber(String number) {
        if (!number.matches(ZERO_OR_POSITIVE_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자는 0 또는 양수이어야 합니다.");
        }
    }

    int sum() {
        return numbers.stream()
                .reduce(INITIAL_SUM_VALUE, Integer::sum);
    }
}
