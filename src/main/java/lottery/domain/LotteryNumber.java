package lottery.domain;

import java.util.Objects;

public class LotteryNumber implements Comparable<LotteryNumber> {

    public static int UPPER_BOUND_INCLUSIVE = 65;
    public static int LOWER_BOUND_INCLUSIVE = 1;

    private final int number;

    public LotteryNumber(int number) {
        if (LOWER_BOUND_INCLUSIVE > number || UPPER_BOUND_INCLUSIVE < number) {
            throw new IllegalArgumentException("number range is " + LOWER_BOUND_INCLUSIVE +
                    " to " + UPPER_BOUND_INCLUSIVE);
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
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LotteryNumber o) {
        return Integer.compare(this.number, o.number);
    }
}
