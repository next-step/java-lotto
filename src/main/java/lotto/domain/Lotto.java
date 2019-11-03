package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int findMatchedNumberCount(final List<Integer> winNumbers) {
        return (int) winNumbers.stream().filter(numbers::contains).count();
    }

    public List<Integer> findNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public int countNumber() {
        return this.numbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
