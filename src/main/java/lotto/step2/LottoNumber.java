package lotto.step2;

import java.util.Objects;

public class LottoNumber {

    private final static int MIN = 1;
    private final static int MAX = 45;
    private final static String ILLEGAL_NUMBER = "유효범위를 벗어난 숫자입니다.";

    private int number;

    public LottoNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER);
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) other;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

