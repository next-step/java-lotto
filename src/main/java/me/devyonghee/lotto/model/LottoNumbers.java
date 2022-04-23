package me.devyonghee.lotto.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public final class LottoNumbers {

    private static final String NULL_NUMBERS_ERROR_MESSAGE = "numbers must not be null";
    private static final String EMPTY_NUMBERS_ERROR_MESSAGE = "numbers must not be empty";

    private final Collection<LottoNumber> numbers;

    private LottoNumbers(Collection<LottoNumber> numbers) {
        Objects.requireNonNull(numbers, NULL_NUMBERS_ERROR_MESSAGE);
        validateEmpty(numbers);
        this.numbers = new HashSet<>(numbers);
    }

    public static LottoNumbers from(Collection<LottoNumber> numbers) {
        return new LottoNumbers(numbers);
    }

    int size() {
        return numbers.size();
    }

    public Collection<LottoNumber> collection() {
        return Collections.unmodifiableCollection(numbers);
    }

    private void validateEmpty(Collection<LottoNumber> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NUMBERS_ERROR_MESSAGE);
        }
    }
}
