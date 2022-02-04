package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> get() {
        return Collections.unmodifiableList(numbers);
    }

    public int countMatches(final List<Integer> comparison) {
        return (int) numbers.stream()
            .filter(comparison::contains)
            .count();
    }

    public boolean hasBonus(final int comparison) {
        return numbers.stream()
            .anyMatch(number -> number == comparison);
    }
}
