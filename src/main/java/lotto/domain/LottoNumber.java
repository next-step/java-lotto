package lotto.domain;

import lotto.exception.LottoNumberSizeException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private final int number;

    public LottoNumber(int number) {
        validNumber(number);
        this.number = number;
    }

    private void validNumber(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new LottoNumberSizeException();
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return number - lottoNumber.number;
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
}
