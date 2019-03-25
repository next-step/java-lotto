package lottery.domain;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumber implements Comparable<LotteryNumber> {

    private static Map<Integer, LotteryNumber> cache;

    public static int UPPER_BOUND_INCLUSIVE = 65;
    public static int LOWER_BOUND_INCLUSIVE = 1;

    static {
        cache = IntStream.rangeClosed(LOWER_BOUND_INCLUSIVE, UPPER_BOUND_INCLUSIVE)
            .boxed()
            .collect(Collectors.toMap(
                    n -> n,
                    n -> new LotteryNumber(n)
            ));
    }

    private final int number;

    private LotteryNumber(int number) {
        if (LOWER_BOUND_INCLUSIVE > number || UPPER_BOUND_INCLUSIVE < number) {
            throw new IllegalArgumentException("number range is " + LOWER_BOUND_INCLUSIVE +
                    " to " + UPPER_BOUND_INCLUSIVE);
        }
        this.number = number;
    }

    public static LotteryNumber of(int number) {
        return cache.entrySet()
                .stream()
                .filter(entry -> entry.getKey() == number)
                .map(e -> e.getValue())
                .findAny()
                .orElse(new LotteryNumber(number));
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
