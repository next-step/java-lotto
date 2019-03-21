package lottogame.domain;

import lottogame.validator.InputValidatable;

import java.util.Objects;

public class LottoNumber implements InputValidatable<Integer> {
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean equalsNumber(int number) {
        return this.number == number;
    }

    @Override
    public boolean isInvalid(Integer target) {
        return target < MINIMUM_LOTTO_NUMBER || target > MAXIMUM_LOTTO_NUMBER;
    }

    @Override
    public String getInvalidMessage() {
        return MINIMUM_LOTTO_NUMBER + "이상 " + MAXIMUM_LOTTO_NUMBER + "이하의 숫자를 입력하세요.";
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