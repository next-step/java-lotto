package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MAX_NUMBER = 45;

    private final int number;

    private LottoNumber(final int number) {
        if (number < 1 || number > MAX_NUMBER) {
            throw new IllegalArgumentException("올바른 로또 번호가 아닙니다.(1이상 45이하 아님)");
        }
        this.number = number;
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
        return Objects.hashCode(number);
    }

    @Override
    public int compareTo(final LottoNumber order) {
        return Integer.compare(this.number, order.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public static LottoNumber valueOf(final int number) {
        return new LottoNumber(number);
    }
}
