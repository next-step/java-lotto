package domain;

import java.util.Objects;

public class LotteryNumber {
    private static final String LOTTERY_NUMBER_ERROR_MESSAGE = "error : 사용할수 있는 로또번호가 아닙니다.";
    private static final int LOTTERY_NUMBER_MIN = 1;
    private static final int LOTTERY_NUMBER_MAX = 45;

    private final int number;

    public LotteryNumber(int number) {
        validLotteryNumber(number);
        this.number = number;
    }

    private void validLotteryNumber(int number) {
        if (number < LOTTERY_NUMBER_MIN || number > LOTTERY_NUMBER_MAX) {
            throw new IllegalArgumentException(LOTTERY_NUMBER_ERROR_MESSAGE);
        }
    }

    public int value() {
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
