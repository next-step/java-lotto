package lotto.domain;

import lotto.exception.NotNumberRangeException;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (!isNumberRange(number)) {
            throw new NotNumberRangeException();
        }
    }

    private boolean isNumberRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    public boolean isBonusBall(int bonusBall) {
        return number == bonusBall;
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
