package lotto.model;


import java.util.Objects;

public class LottoNumber {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private int value;

    public LottoNumber(String value) {

        this(Integer.parseInt(value));
    }

    public LottoNumber(int value) {
        if (value < MINIMUM_NUMBER || value > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 가능");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
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
