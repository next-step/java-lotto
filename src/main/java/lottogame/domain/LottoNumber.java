package lottogame.domain;

import lottogame.validator.LottoNumberValidator;
import lottogame.validator.Validatable;

import java.util.Objects;

public class LottoNumber {
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int number;
    private final Validatable<Integer> validator = new LottoNumberValidator();

    public LottoNumber(InputLine inputLine) {
        this(Integer.parseInt(inputLine.getLine()));
    }

    public LottoNumber(int number) {
        validator.validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean equalsNumber(int number) {
        return this.number == number;
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
}