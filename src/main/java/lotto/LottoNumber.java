package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    
    private final static Integer MIN_LOTTO_NUMBER = 1;
    private final static Integer MAX_LOTTO_NUMBER = 45;
    private int number;

    LottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
