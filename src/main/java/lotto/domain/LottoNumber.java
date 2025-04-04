package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int value;

    public LottoNumber(String value) {
        this(Integer.parseInt(value));
    }

    public LottoNumber(int value) {
        checkValue(value);
        this.value = value;
    }

    private void checkValue(int value) {
        if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("invalid Lotto number : " + value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber lottoNumber = (LottoNumber) o;
        return value == lottoNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
