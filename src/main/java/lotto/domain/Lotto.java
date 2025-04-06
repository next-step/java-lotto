package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    public final int MIN_NUMBER = 1;
    public final int MAX_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        Objects.requireNonNull(numbers, "numbers must not be null");

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("Lotto numbers must contain exactly 6 numbers.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("Lotto numbers must be unique.");
        }

        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("Lotto number " + number + " is out of valid range (1-45).");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
