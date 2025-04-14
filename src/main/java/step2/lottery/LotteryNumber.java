package step2.lottery;

import java.util.HashMap;
import java.util.Map;

public class LotteryNumber implements Comparable<LotteryNumber> {
    private final int number;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Map<Integer, LotteryNumber> CACHE = new HashMap<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            CACHE.put(i, new LotteryNumber(i));
        }
    }

    public LotteryNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
        this.number = number;
    }

    public static LotteryNumber of(int number) {
        LotteryNumber cached = CACHE.get(number);
        if (cached == null) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
        return cached;
    }

    @Override
    public int compareTo(LotteryNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}