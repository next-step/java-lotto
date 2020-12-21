package calculator.domain;

import calculator.util.ValidateUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private static final String VALID_EMPTY_NUMBERS_MESSAGE = "입력 값이 없습니다.";
    private static final String VALID_NO_NUMBER_MESSAGE = "숫자가 아닙니다.";

    private final List<Integer> numbers;

    public Numbers(StringSplitor stringSplitor) {
        String[] inputs = stringSplitor.splitSeparator();
        validateNumbers(inputs);
        numbers = mapNumbers(inputs);
        Collections.unmodifiableList(numbers);
    }

    private List<Integer> mapNumbers(String[] numbers) {
        return Arrays.asList(numbers).stream()
                .map(i -> parseNumber(i))
                .collect(Collectors.toList());
    }

    private int parseNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            ValidateUtils.validateNegativeNumber(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALID_NO_NUMBER_MESSAGE);
        }
    }

    private void validateNumbers(String[] inputs) {
        if (inputs == null || inputs.length == 0) {
            throw new IllegalArgumentException(VALID_EMPTY_NUMBERS_MESSAGE);
        }
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
