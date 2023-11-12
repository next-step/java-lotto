package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private int number;

    LottoNumber(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException();
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
        return Objects.hash(number);
    }


    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
