package lottery;

import java.util.Objects;

public class LotteryNumber implements Comparable<LotteryNumber>{

    public static final int LOTTERY_NUM_MIN = 1;
    public static final int LOTTERY_NUM_MAX = 45;

    private final int lotteryNumber;

    public LotteryNumber(int lotteryNumber) {
        validate(lotteryNumber);
        this.lotteryNumber = lotteryNumber;
    }

    private void validate(int lotteryNumber) {
        if (lotteryNumber < LOTTERY_NUM_MIN || lotteryNumber > LOTTERY_NUM_MAX) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 정수여야 합니다.");
        }
    }

    @Override
    public int compareTo(LotteryNumber o) {
        return this.lotteryNumber - o.lotteryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return lotteryNumber == that.lotteryNumber;
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
