package domain.lottery;

import java.util.Objects;

public class LotteryNumber {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int number;

    private LotteryNumber(int number) {
        this.number = number;

        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 번호입니다.");
        }
    }

    public static LotteryNumber of(int number) {
        return new LotteryNumber(number);
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
