package me.devyonghee.lotto.model;

import java.util.Objects;

public final class Lotto {

    public static final int NUMBER_SIZE = 6;

    private static final String NULL_NUMBERS_ERROR_MESSAGE = "numbers must not be null";
    private static final String INVALID_NUMBERS_SIZE_ERROR_MESSAGE_FORMAT = "lotto numbers size(%d) must be %d";
    private static final String NULL_LOTTO_TO_RANK_ERROR_MESSAGE = "lotto to rank must not be null";
    private static final String TO_STRING_START = "Lotto{";
    private static final char TO_STRING_END = '}';
    private static final String TO_STRING_NUMBERS_FIELD = "numbers=";

    private final LottoNumbers numbers;

    private Lotto(LottoNumbers numbers) {
        Objects.requireNonNull(numbers, NULL_NUMBERS_ERROR_MESSAGE);
        validateSize(numbers);
        this.numbers = numbers;
    }

    static Lotto from(LottoNumbers numbers) {
        return new Lotto(numbers);
    }

    public LottoNumbers numbers() {
        return numbers;
    }

    Rank rank(Lotto lotto, LottoNumber bonusNumber) {
        Objects.requireNonNull(lotto, NULL_LOTTO_TO_RANK_ERROR_MESSAGE);
        Objects.requireNonNull(bonusNumber, NULL_LOTTO_TO_RANK_ERROR_MESSAGE);
        return Rank.of(numbers.matchCount(lotto.numbers), numbers.contains(bonusNumber));
    }

    boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    private void validateSize(LottoNumbers numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBERS_SIZE_ERROR_MESSAGE_FORMAT, numbers.size(), NUMBER_SIZE));
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
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public String toString() {
        return TO_STRING_START +
                TO_STRING_NUMBERS_FIELD + numbers +
                TO_STRING_END;
    }
}
