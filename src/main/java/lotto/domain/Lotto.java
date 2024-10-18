package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public Lotto(final Integer... numbers) {
        this.numbers = Arrays.stream(numbers)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public int sumMatchCount(final List<Number> others) {
        return others.stream()
                .mapToInt(other -> other.countMatch(numbers))
                .sum();
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
