package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatches(Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("Lotto must have " + LOTTO_SIZE + " numbers.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean hasOutOfRange = numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);
        if (hasOutOfRange) {
            throw new IllegalArgumentException(
                    "Lotto numbers must be between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("Lotto numbers must not be duplicated.");
        }
    }
}
