package lotto.domain;

import lotto.domain.exceptions.InvalidLottoNumberException;

import java.util.Objects;

public class LottoNumber {
    private final int value;

    public LottoNumber(final int value) {
        validate(value);

        this.value = value;
    }

    private void validate(final int value) {
        if (value <= 0 || value > 45) {
            throw new InvalidLottoNumberException("유효하지 않은 LottoNumber 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
    }
}
