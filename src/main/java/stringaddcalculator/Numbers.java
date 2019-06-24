package stringaddcalculator;

import java.util.List;

public class Numbers {
    private static final Integer ZERO = 0;

    private List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        validateNegative(numbers);
        this.numbers = numbers;
    }

    public static Numbers of(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    private void validateNegative(List<Integer> numbers) {
        if (isNegative(numbers)) {
            throw new IllegalArgumentException("Number is negative");
        }
    }

    private boolean isNegative(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < ZERO);
    }

    public int sum() {
        return numbers.stream()
                .reduce((n1, n2) -> n1 + n2)
                .orElse(0);
    }
}
