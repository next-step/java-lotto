package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;

    private final int number;

    public LottoNumber(int number) {
        if (number > LottoNumber.MAX_NUMBER || number < LottoNumber.MIN_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이입니다.");
        }
        this.number = number;
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber number) {
        return Integer.compare(this.number, number.value());
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
