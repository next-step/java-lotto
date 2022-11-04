package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable {
    private int number;

    public LottoNumber(String number) {
        this.number = Integer.parseInt(number);
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Object o) {
        LottoNumber that = (LottoNumber) o;
        if (this.number == that.getNumber())
            return 0;
        return (this.number > that.getNumber()) ? 1 : -1;
    }
}
