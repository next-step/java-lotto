package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int value;

    public LottoNumber(final int value) {
        this.value = value;
    }

    int value() {
        return this.value;
    }

    public static LottoNumber from(final int value) {
        validateLottoNumberIsInRange(value);

        return new LottoNumber(value);
    }

    private static void validateLottoNumberIsInRange(final int value) {
        if (value < MINIMUM_LOTTO_NUMBER || value > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1이상 45이하의 자연수여야 합니다. 번호: " + value);
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
