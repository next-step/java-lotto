package study.lotto.domain;

import study.lotto.exception.LottoException;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN_NUMBER_BOUND = 1;
    public static final int MAX_NUMBER_BOUND = 45;

    private final int number;

    public LottoNumber(int number) {
        if(isInvalidNumber(number)) {
            throw new LottoException();
        }
        this.number = number;
    }

    private boolean isInvalidNumber(int number) {
        return MIN_NUMBER_BOUND > number || MAX_NUMBER_BOUND < number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        final LottoNumber that = (LottoNumber) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
