package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 45;

    private final int value;

    public LottoNumber(String value) {
        this(Integer.parseInt(value));
    }

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (isSmallerThanMinValue(value)) {
            throw new IllegalArgumentException(String.format("값(%s)은 %s보다 작을 수 없다.", value, MIN_VALUE));
        }

        if (isBiggerThanMaxValue(value)) {
            throw new IllegalArgumentException(String.format("값(%s)은 %s보다 클 수 없다.", value, MAX_VALUE));
        }
    }

    private boolean isSmallerThanMinValue(int value) {
        return value < MIN_VALUE;
    }

    private boolean isBiggerThanMaxValue(int value) {
        return value > MAX_VALUE;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if (lottoNumber.value < this.value) {
            return 1;
        } else if (lottoNumber.value > this.value) {
            return -1;
        }
        return 0;
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
        return Integer.toString(value);
    }
}
