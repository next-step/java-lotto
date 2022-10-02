package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(RandomGenerator randomGenerator) {
        numbers = randomGenerator.randomNumbers();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> numbers() {
        return Collections.unmodifiableList(numbers);
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

    public Integer matchedCount(Lotto another) {
        return another.numbers()
                .stream()
                .reduce(0, this::incrementIfMatched);
    }

    private int incrementIfMatched(Integer total, Integer number) {
        if (numbers.contains(number)) {
            return total + 1;
        }
        return total;
    }
}
