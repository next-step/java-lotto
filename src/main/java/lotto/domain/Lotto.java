package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int countMatch(final String winningNumber) {
        return (int) numbers.stream()
                .filter(number -> winningNumber.contains(String.valueOf(number)))
                .count();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
