package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final int value;

    public LottoNumber(String value) {
        this(Integer.parseInt(value));
    }

    public LottoNumber(int value) {
        checkValue(value);
        this.value = value;
    }

    private void checkValue(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("LottoNumber is between 1 and 45");
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
