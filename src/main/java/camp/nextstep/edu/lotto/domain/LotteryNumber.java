package camp.nextstep.edu.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumber implements Comparable<LotteryNumber> {
    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 45;
    private static final LotteryNumber MINIMUM_LOTTERY_NUMBER = LotteryNumber.from(MINIMUM_VALUE);
    private static final LotteryNumber MAXIMUM_LOTTERY_NUMBER = LotteryNumber.from(MAXIMUM_VALUE);
    private static final List<LotteryNumber> ALL_LOTTERY_NUMBERS = IntStream.rangeClosed(MINIMUM_VALUE, MAXIMUM_VALUE)
            .boxed()
            .map(LotteryNumber::from)
            .collect(Collectors.toList());

    private final int value;

    private LotteryNumber(int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException("'intValue' must be greater than or equal to " + MINIMUM_VALUE);
        }
        if (value > MAXIMUM_VALUE) {
            throw new IllegalArgumentException("'intValue' must be less than or equal to " + MAXIMUM_VALUE);
        }
        this.value = value;
    }

    public static LotteryNumber from(int value) {
        return new LotteryNumber(value);
    }

    public static LotteryNumber min() {
        return MINIMUM_LOTTERY_NUMBER;
    }

    public static LotteryNumber max() {
        return MAXIMUM_LOTTERY_NUMBER;
    }

    public static List<LotteryNumber> allNumbers() {
        return new ArrayList<>(ALL_LOTTERY_NUMBERS);
    }

    public int value() {
        return value;
    }

    @Override
    public int compareTo(LotteryNumber o) {
        return Integer.compare(value, o.value);
    }

    @Override
    public String toString() {
        return "LotteryNumber{" +
                "intValue=" + value +
                '}';
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
}
