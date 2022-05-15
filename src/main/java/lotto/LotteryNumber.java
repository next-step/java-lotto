package lotto;

import java.util.Objects;

public class LotteryNumber implements Comparable<LotteryNumber> {
    private final int value;

    public LotteryNumber(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("Lottery Number should be 1 ~ 45");
        }
        this.value = value;
    }

    @Override
    public int compareTo(LotteryNumber o) {
        return Integer.compare(value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
