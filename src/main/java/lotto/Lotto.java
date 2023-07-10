package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Lotto {

    private final List<Number> numbers;

    public Lotto(final List<Integer> numbers) {
        this.numbers = numbers.stream()
                .map(Number::of)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
