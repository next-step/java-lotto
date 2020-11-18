package domain;

import java.util.*;

public class Lotto {
    private List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public Long countMatching(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
