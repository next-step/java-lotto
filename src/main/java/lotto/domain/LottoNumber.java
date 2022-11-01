package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

    public static final int LOTTO_MAX_NUM = 45;
    public static final int LOTTO_MIN_NUM = 1;

    private final int number;

    public LottoNumber(int number) {
        if(number > LOTTO_MAX_NUM || number < LOTTO_MIN_NUM) {
            throw new IllegalArgumentException("lotto number cannot be bigger than 45 or smaller than 1");
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
        return Objects.hash(number);
    }


    @Override
    public int compareTo(LottoNumber o) {
        return  this.number - o.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
