package edu.nextstep.camp.lotto.domain;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final int SIZE_OF_NUMBERS = 6;
    private static final String FORMATTER = "Lotto{numbers=%s)";

    private final Collection<LottoNumber> numbers;

    private Lotto(Collection<LottoNumber> numbers) {
        this.numbers = numbers.stream()
                .sorted(Comparator.comparingInt(LottoNumber::toInt))
                .collect(Collectors.toUnmodifiableList());
    }

    public static Lotto fromLottoNumbers(Collection<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException("invalid input: size of numbers must be " + SIZE_OF_NUMBERS);
        }

        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("invalid input: duplicated numbers are found: " + numbers);
        }

        return new Lotto(numbers);
    }

    public static Lotto fromIntegers(Collection<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("invalid input: size of numbers must be " + SIZE_OF_NUMBERS);
        }

        return Lotto.fromLottoNumbers(numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return numbers.containsAll(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public Collection<LottoNumber> collect() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.format(FORMATTER, numbers.toString());
    }

    public int matchedCount(Lotto winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber.numbers::contains)
                .count();
    }
}
