package lotto2.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final int MINIMUM_LOTTO_NUMBER = 1;

    private final int number;

    public LottoNumber(final int number) {
        this.number = validate(number);
    }

    private int validate(int number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또는 1과 45사이의 숫자만 가능합니다.");
        }
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber l) {
        return this.number - l.number;
    }
}
