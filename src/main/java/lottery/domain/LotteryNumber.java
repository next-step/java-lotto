package lottery.domain;

import lottery.domain.exception.InvalidLotteryNumberException;

import java.util.stream.IntStream;

public class LotteryNumber implements Comparable<LotteryNumber> {
    public static final int MIN =  1;
    public static final int MAX = 45;

    public static final LotteryNumber[] cache = IntStream.rangeClosed(0, MAX)
            .mapToObj(LotteryNumber::new)
            .toArray(LotteryNumber[]::new);

    private final int number;

    private static void sanitizeNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new InvalidLotteryNumberException();
        }
    }

    public static LotteryNumber valueOf(String number) {
        return valueOf(Integer.parseInt(number));
    }

    public static LotteryNumber valueOf(int number) {
        sanitizeNumber(number);
        return cache[number];
    }

    private LotteryNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LotteryNumber other) {
        return Integer.compare(number, other.number);
    }
}
