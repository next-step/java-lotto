package lotto.model;

import java.util.Objects;

import static lotto.validation.LottoNumberValidator.assertInvalidNumber;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        assertInvalidNumber(number);

        this.number = number;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        LottoNumber that = (LottoNumber) other;
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
}
