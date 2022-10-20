package lotto;

import java.util.Objects;

public class LotteryNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public LotteryNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_VALUE || number > MAX_NUMBER) {
            throw new LotteryGameException(ErrorCode.OUT_OF_RANGE_NUMBER);
        }
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
