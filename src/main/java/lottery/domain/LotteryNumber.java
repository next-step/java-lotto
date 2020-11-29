package lottery.domain;

import java.util.Objects;

public class LotteryNumber implements Comparable{
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private final int number;

    public LotteryNumber(int number) {
        if (number < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 0보다 커야 합니다.");
        }
        if (number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 45보다 작아야 합니다.");
        }
        this.number = number;
    }

    public int isContainNumber(LotteryTicket winningLotteryTicket) {
        if (winningLotteryTicket.getLotteryNumbers().contains(this)) {
            return 1;
        }
        return 0;
    }

    public int getNumber() {
        return this.number;
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
