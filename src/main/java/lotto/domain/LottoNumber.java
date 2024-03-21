package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    public LottoNumber(int number) {
        if (!isLottoNumber(number)) {
            throw new IllegalArgumentException("로또숫자는 1-45 사이의 수만 가능합니다.");
        }
        this.number = number;
    }

    private boolean isLottoNumber(int number) {
        return number >= 1 && number <= 45;
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
    public int compareTo(LottoNumber other) {
        return this.number - other.number ;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
