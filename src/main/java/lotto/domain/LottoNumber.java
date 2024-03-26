package lotto.domain;

import static lotto.config.LottoExceptionMessage.LOTTO_NUMBER_SHOULD_BE_IN_VALID_RANGE;

import java.util.Objects;

class LottoNumber {

    static final int MINIMUM = 1;
    static final int MAXIMUM = 45;

    private final int value;

    LottoNumber(final int value) {
        this.value = value;
    }

    static LottoNumber from(final int value) {
        validateLottoNumberIsInRange(value);

        return new LottoNumber(value);
    }

    private static void validateLottoNumberIsInRange(final int value) {
        if (value < MINIMUM || value > MAXIMUM) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SHOULD_BE_IN_VALID_RANGE.message(value));
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

        return this.value == ((LottoNumber)other).value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }
}
