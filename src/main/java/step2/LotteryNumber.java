package step2;

import java.util.Objects;

public class LotteryNumber {
    private final int number;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public LotteryNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LotteryNumber) {
            return this.number == ((LotteryNumber) obj).number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}