package me.devyonghee.lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class LottoNumbers {

    private static final String NUMBERS_NULL_ERROR = "numbers must not be null";
    private static final String NUMBERS_EMPTY_ERROR = "numbers must not be empty";

    private final List<LottoNumber> numbers;

    private LottoNumbers(List<LottoNumber> numbers) {
        Objects.requireNonNull(numbers, NUMBERS_NULL_ERROR);
        validateEmpty(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static LottoNumbers from(List<LottoNumber> numbers) {
        return new LottoNumbers(numbers);
    }

    int size() {
        return numbers.size();
    }

    private void validateEmpty(List<LottoNumber> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(NUMBERS_EMPTY_ERROR);
        }
    }
}
