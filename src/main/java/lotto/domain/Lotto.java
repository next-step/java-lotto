package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(String input) {
        return new Lotto(Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .map(Number::new)
                .collect(Collectors.toList()));
    }

    public List<Number> values() {
        return numbers;
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

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    public boolean isValidRange() {
        return numbers.stream().allMatch(Number::isValidRange);
    }

    public boolean isSorted() {
        return IntStream.range(0, numbers.size()-1)
                .allMatch(i -> numbers.get(i).isSmallerThan(numbers.get(i+1)));
    }
}
