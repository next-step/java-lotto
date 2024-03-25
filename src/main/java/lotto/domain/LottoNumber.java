package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int value;

    public LottoNumber(final Integer value) {
        if (validateLottoNumber(value)) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    private boolean validateLottoNumber(int value) {
        return MINIMUM_LOTTO_NUMBER > value || value > MAXIMUM_LOTTO_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return value == lottoNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
