package lotto.domain.number;

import lotto.constant.ErrorMessage;

import java.util.Objects;

public class LottoNumber {

    private final static int MIN_BOUND = 1;
    private final static int MAX_BOUND = 45;

    private final int number;

    private LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < MIN_BOUND || number > MAX_BOUND) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public int number() {
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
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
