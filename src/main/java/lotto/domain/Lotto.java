package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean hasSize(int number) {
        return this.numbers.size() == number;
    }

    public boolean isValidRangeNumbers() {
        return this.numbers.stream().noneMatch(number -> number < 1 || number > 45);
    }

    public boolean isSorted() {
        return IntStream.range(0, numbers.size() - 1).allMatch(i -> numbers.get(i) < numbers.get(i + 1));
    }

    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
