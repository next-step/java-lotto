package lotto.domain.lotto;

import java.util.Objects;

public class Number implements Comparable<Number> {
    int lottoNumber;

    private Number(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static Number create(int lottoNumber) {
        return new Number(lottoNumber);
    }

    @Override
    public int compareTo(Number out) {
        if (this.lottoNumber > out.lottoNumber)
            return 1;
        if (this.lottoNumber < out.lottoNumber)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number = (Number) o;
        return lottoNumber == number.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
