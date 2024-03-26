package lotto.domain;

import static lotto.config.LottoExceptionMessage.LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE;

import java.util.Set;

class Lotto {

    static final int SIZE = 6;

    private final Set<LottoNumber> numbers;

    private Lotto(final Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    static Lotto from(final Set<LottoNumber> numbers) {
        validateNumbersHaveSpecifiedSize(numbers);

        return new Lotto(numbers);
    }

    private static void validateNumbersHaveSpecifiedSize(final Set<LottoNumber> numbers) {
        if (numbers.size() < SIZE || numbers.size() > SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE.message(numbers.size()));
        }
    }
}
