package me.devyonghee.lotto.model;

import java.util.Objects;

public final class LottoTicket {

    public static final int NUMBER_SIZE = 6;

    private static final String NULL_NUMBERS_ERROR_MESSAGE = "numbers must not be null";
    private static final String INVALID_NUMBERS_SIZE_ERROR_MESSAGE_FORMAT = "lotto numbers size(%d) must be %d";

    private LottoNumbers numbers;

    private LottoTicket(LottoNumbers numbers) {
        Objects.requireNonNull(numbers, NULL_NUMBERS_ERROR_MESSAGE);
        validateSize(numbers);
        this.numbers = numbers;
    }

    public static LottoTicket from(LottoNumbers numbers) {
        return new LottoTicket(numbers);
    }

    public LottoNumbers numbers() {
        return numbers;
    }

    private void validateSize(LottoNumbers numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBERS_SIZE_ERROR_MESSAGE_FORMAT, numbers.size(), NUMBER_SIZE));
        }
    }
}
