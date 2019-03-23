package lotto.domain;

import lotto.LottoNumberGenerator;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private int value;

    public LottoNumber() {
        this.value = LottoNumberGenerator.generate(MIN, MAX);
    }

    public LottoNumber(int value) {
        if (value < MIN) {
            throw new IllegalArgumentException(MIN +" OR MORE");
        }

        if (value > MAX) {
            throw new IllegalArgumentException(MAX + " OR LESS");
        }

        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
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
}
