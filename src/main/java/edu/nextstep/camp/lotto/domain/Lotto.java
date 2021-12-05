package edu.nextstep.camp.lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    public static final int SIZE_OF_NUMBERS = 6;
    private static final String FORMATTER = "Lotto{numbers=%s)";

    private final Set<LottoNumber> numbers;

    private Lotto(Set<LottoNumber> numbers) {
        this.numbers = Collections.unmodifiableSortedSet(new TreeSet<>(numbers));
    }

    public static Lotto fromLottoNumbers(Set<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException("invalid input: size of numbers must be " + SIZE_OF_NUMBERS);
        }

        return new Lotto(numbers);
    }

    public static Lotto fromIntegers(Collection<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("invalid input: size of numbers must be " + SIZE_OF_NUMBERS);
        }

        return Lotto.fromLottoNumbers(numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
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

    public Set<LottoNumber> collect() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.format(FORMATTER, numbers);
    }

    public int matchedCount(Lotto winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber.numbers::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }
}
