package lotto.domain;

import lotto.exception.InvalidLottoNumber;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        verifyNumber(number);
        this.number = number;
    }

    private void verifyNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new InvalidLottoNumber(String.format("%s %d", InvalidLottoNumber.INVALID_LOTTO_NUMBER, number));
        }
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
        return number - o.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
