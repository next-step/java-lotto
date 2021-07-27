package lotto.domain;

import lotto.exception.IllegalLottoNumberException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber of(String number) {
        return new LottoNumber(Integer.parseInt(number));
    }

    public int initNumber() {
        return number;
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
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber number) {
        return this.number - number.initNumber();
    }

    private void validate(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalLottoNumberException(number);
        }
    }
}
