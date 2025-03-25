package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream().map(Number::new).collect(Collectors.toList());
    }

    public boolean hasSize(int number) {
        return this.numbers.size() == number;
    }

    public boolean isValidRangeNumbers() {
        return this.numbers.stream().allMatch(Number::isValidRangeNumber);
    }

    public boolean isSorted() {
        return IntStream.range(0, numbers.size() - 1).allMatch(i -> numbers.get(i).isSmallerThan(numbers.get(i + 1)));
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

    public int getMatchNum(Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }
}
