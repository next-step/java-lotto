package lottery.domain;

import java.util.Objects;

public class LotteryNumber {

    public static final int MAXIMUM = 45;
    public static final int MINIMUM = 1;

    private final Integer lotteryNumber;

    LotteryNumber(Integer number) {
        if (number > MAXIMUM || number < MINIMUM) {
            throw new IllegalArgumentException("로또번호는 " + MINIMUM + " ~ " + MAXIMUM + " 사이의 숫자이어야 합니다.");
        }

        this.lotteryNumber = number;
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

    @Override
    public String toString() {
        return String.valueOf(lotteryNumber);
    }
}
