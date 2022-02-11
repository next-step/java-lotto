package lotto.domain;

import java.util.Objects;
import lotto.LottoBalls;

public class LottoNumber implements Comparable {

    private final int value;

    public LottoNumber(int value) {
        this.value = value;
    }

    private void validateLottoNumberRange(final int value) {
        if (isNotLottoNumberRange(value)) {
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(Object o) {
        LottoNumber target = (LottoNumber) o;
        return this.value - target.value;
    }
}
