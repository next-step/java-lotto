package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;

import java.util.Objects;

public class LotteryNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LotteryNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public LotteryNumber(String number) {
        this.number = parseInt(number);
    }

    private static int parseInt(String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new LotteryGameException(ErrorCode.NULL_OR_EMPTY);
        }
        return Integer.parseInt(number);
    }

    private void validateRange(int number) {
        if (number < MIN_VALUE || number > MAX_NUMBER) {
            throw new LotteryGameException(ErrorCode.OUT_OF_RANGE_NUMBER);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
