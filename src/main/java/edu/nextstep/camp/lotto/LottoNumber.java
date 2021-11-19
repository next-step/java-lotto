package edu.nextstep.camp.lotto;

import java.util.Objects;

public class LottoNumber {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static  LottoNumber of (int number) {
        if (number < MINIMUM || number > MAXIMUM) {
            throw new IllegalArgumentException("invalid input: the number must be between 1 and 45. number: " + number);
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

    public int toInt() {
        return number;
    }

    public String toString() {
        return String.format("LottoNumber(%d)", number);
    }
}
