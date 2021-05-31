package lottery;

import java.util.Objects;

public class LotteryNumber {

    private static final int MAXIMUM_LOTTERY_NUMBER = 45;
    private static final int MINIMUM_LOTTERY_NUMBER = 1;

    private final Integer lotteryNumber;

    LotteryNumber(Integer number) {
        if (number > MAXIMUM_LOTTERY_NUMBER || number < MINIMUM_LOTTERY_NUMBER) {
            throw new IllegalArgumentException("로또번호는 1 ~ 45 사이의 숫자이어야 합니다.");
        }

        lotteryNumber = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return Objects.equals(lotteryNumber, that.lotteryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryNumber);
    }
}
