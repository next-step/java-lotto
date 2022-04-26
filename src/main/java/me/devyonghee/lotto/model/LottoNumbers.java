package me.devyonghee.lotto.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public final class LottoNumbers {

    private static final String NULL_NUMBERS_ERROR_MESSAGE = "numbers must not be null";
    private static final String EMPTY_NUMBERS_ERROR_MESSAGE = "numbers must not be empty";
    private static final String TO_STRING_START = "LottoNumbers{";
    private static final String TO_STRING_NUMBERS_FIELD = "numbers=";
    private static final char TO_STRING_END = '}';

    private final Collection<LottoNumber> numbers;

    private LottoNumbers(Collection<LottoNumber> numbers) {
        Objects.requireNonNull(numbers, NULL_NUMBERS_ERROR_MESSAGE);
        validateEmpty(numbers);
        this.numbers = new HashSet<>(numbers);
    }

    static LottoNumbers from(Collection<LottoNumber> numbers) {
        return new LottoNumbers(numbers);
    }

    int size() {
        return numbers.size();
    }

    public Collection<LottoNumber> collection() {
        return Collections.unmodifiableCollection(numbers);
    }

    long matchCount(LottoNumbers lottoNumbers) {
        return this.numbers.stream()
                .filter(lottoNumbers.numbers::contains)
                .count();
    }

    boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    private void validateEmpty(Collection<LottoNumber> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NUMBERS_ERROR_MESSAGE);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public String toString() {
        return TO_STRING_START +
                TO_STRING_NUMBERS_FIELD + numbers +
                TO_STRING_END;
    }
}
