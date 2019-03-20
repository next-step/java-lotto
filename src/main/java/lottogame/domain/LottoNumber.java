package lottogame.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        if(isInvalid(number)) {
            throw new IllegalArgumentException(MINIMUM_LOTTO_NUMBER + "이상 " + MAXIMUM_LOTTO_NUMBER + "이하의 숫자를 입력하세요.");
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static boolean isInvalid(int number) {
        return number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER;
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