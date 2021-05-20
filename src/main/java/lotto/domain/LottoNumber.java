package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber create(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("잘못된 로또 범위 입니다. (1~45사이)");
        }
        return new LottoNumber(number);
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
    public int compareTo(LottoNumber o) {
        if (this.number > o.number) {
            return 1;
        }

        if (this.number < o.number) {
            return -1;
        }

        return 0;
    }

}
