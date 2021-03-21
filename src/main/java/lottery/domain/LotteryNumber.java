package lottery.domain;

import java.util.Objects;

public class LotteryNumber {

    static final int LOTTERY_NUMBER_MIN = 1;
    static final int LOTTERY_NUMBER_MAX = 45;

    private final int number;

    public LotteryNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int export() {
        return number;
    }

    private void validate(int number) {
        if(!checkRange(number)) {
            throw new LotteryNumberOutOfRangeException();
        }
    }

    private boolean checkRange(int number) {
        return number >= LOTTERY_NUMBER_MIN && number <= LOTTERY_NUMBER_MAX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LotteryNumber)) return false;
        LotteryNumber that = (LotteryNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
