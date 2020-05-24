package lotto.domain.lotto;

import lotto.domain.lotto.exceptions.OutOfBoundOfLottoNumberException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MAX_VALUE = 45;
    private static final int MIN_VALUE = 1;
    private final int value;

    private LottoNumber(int value) {
        validation(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LottoNumber create(int value) {
        return new LottoNumber(value);
    }

    private void validation(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new OutOfBoundOfLottoNumberException("LottoNumber must in 1 ~ 45");
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

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return Integer.compare(this.value, lottoNumber.value);
    }
}
