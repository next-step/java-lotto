package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass()) return 1;

        LottoNumber number = (LottoNumber) o;
        if (this.number > number.number) {
            return 1;
        }

        if (this.number < number.number) {
            return  -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }
}
