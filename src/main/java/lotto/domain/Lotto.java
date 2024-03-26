package lotto.domain;

import static lotto.config.LottoExceptionMessage.LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE;

import java.util.Objects;
import java.util.Set;

class Lotto {

    static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> numbers;

    Lotto(final Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    static Lotto from(final Set<LottoNumber> numbers) {
        validateNumbersHaveSpecifiedSize(numbers);

        return new Lotto(numbers);
    }

    private static void validateNumbersHaveSpecifiedSize(final Set<LottoNumber> numbers) {
        if (numbers.size() < LOTTO_NUMBERS_SIZE || numbers.size() > LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE.message(numbers.size()));
        }
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        return this.numbers.equals(((Lotto)other).numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numbers);
    }
}
