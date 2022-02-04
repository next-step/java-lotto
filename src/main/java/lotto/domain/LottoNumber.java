package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private int value;

    public LottoNumber(int value) {
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < MIN_RANGE_NUMBER || value > MAX_RANGE_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return value;
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

    @Override
    public int compareTo(LottoNumber o) {
        return this.value-o.value;
    }
}
