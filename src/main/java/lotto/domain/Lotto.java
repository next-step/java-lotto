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

    public String combine(String seperator) {
        return numbers.stream()
                .map(Number::value)
                .map(String::valueOf)
                .collect(Collectors.joining(seperator));
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

    public Rank getRank(Lotto winningLotto, Number bonusNumber) {
        return Rank.valueOf((int) numbers.stream()
                 .filter(winningLotto.numbers::contains)
                 .count()
                , numbers.contains(bonusNumber));
    }

    public boolean isValidRange() {
        return numbers.stream().allMatch(Number::isValidRange);
    }

    public boolean isSorted() {
        return IntStream.range(0, numbers.size()-1)
                .allMatch(i -> numbers.get(i).isSmallerThan(numbers.get(i+1)));
    }
}
