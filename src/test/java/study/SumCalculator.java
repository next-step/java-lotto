package study;

import java.util.List;
import java.util.stream.Collectors;

public class SumCalculator implements Calculator {
    private final String input;
    private final int minValue;

    public SumCalculator(String input, int minValue) {
        this.input = input;
        this.minValue = minValue;
    }

    public int calculate() {
        if (isUnusable()) {
            return minValue;
        }

        return stringToInts(input).stream()
                .mapToInt(this::toValueGreaterThanMinValue)
                .sum();
    }

    private boolean isUnusable() {
        return isNull() || isEmpty();
    }

    private boolean isEmpty() {
        return input.isEmpty();
    }

    private boolean isNull() {
        return input == null;
    }

    private List<Integer> stringToInts(String input) {
        return Splitter.split(input)
                .stream()
                .map(this::parseInt)
                .collect(Collectors.toList());
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값을 넣을 수 없습니다.");
        }
    }

    private int toValueGreaterThanMinValue(int value) {
        if (isLessThanMinValue(value)) {
            throw new RuntimeException("최소값 보다 작은 값은 더할 수 없습니다.");
        }
        return value;
    }

    private boolean isLessThanMinValue(int value) {
        return value < minValue;
    }
}
