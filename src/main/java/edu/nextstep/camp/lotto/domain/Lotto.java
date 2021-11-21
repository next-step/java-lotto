package edu.nextstep.camp.lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Lotto {
    private static final String FORMATTER = "Lotto{numbers=%s)";
    private static final int SIZE_OF_NUMBERS = 6;

    private final Collection<LottoNumber> numbers;

    private Lotto(Collection<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(Collection<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException("invalid input: size of numbers must be " + SIZE_OF_NUMBERS);
        }

        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("invalid input: duplicated numbers are found: " + numbers);
        }

        return new Lotto(Collections.unmodifiableCollection(numbers));
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
}
