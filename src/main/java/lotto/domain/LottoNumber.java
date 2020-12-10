package lotto.domain;

import java.util.Objects;

import lotto.domain.validator.LottoNumberValidator;

public final class LottoNumber {

    public static final int LOWER_BOUND = 1;

    public static final int UPPER_BOUND = 45;

    private final int number;

    public LottoNumber(final String number) {
        this(Integer.parseInt(number));
    }

    public LottoNumber(final int number) {
        this.number = number;

        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException(LottoNumberValidator.OUT_BOUND_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof LottoNumber)) { return false; }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
