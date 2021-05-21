package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private RandomNumber number;

    public LottoNumber() {
    }

    public LottoNumber(RandomNumber randomNumber) {
        this.number = randomNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number.compareTo(o.number);
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
