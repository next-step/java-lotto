package lottery;

import java.util.Objects;

public class LotteryNumber implements Comparable{
    private final int number;

    public LotteryNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("로또 번호는 0보다 커야 합니다.");
        }
        if (number > 45) {
            throw new IllegalArgumentException("로또 번호는 45보다 작아야 합니다.");
        }
        this.number = number;
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

    @Override
    public int compareTo(Object other) {
        LotteryNumber anotherLotteryNumber = (LotteryNumber) other;
        return this.number - anotherLotteryNumber.number;
    }
}
