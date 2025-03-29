package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
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
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("Lotto number " + number + " is out of valid range (1-45).");
            }
        }
    }

    public int countMatches(List<Integer> winningNumbers) {
        validateNumbers(winningNumbers);
        int count = 0;
        for (Integer number : this.numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
