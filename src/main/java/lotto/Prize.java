package lotto;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prize {
    NO_PRIZE(0, 0L),
    FOURTH_PRIZE(3, 5000L),
    THIRD_PRIZE(4, 50000L),
    SECOND_PRIZE(5, 1500000L),
    FIRST_PRIZE(6, 2000000000L);

    private static final Map<Integer, Prize> PRIZE_MAP =
            Stream.of(values()).collect(Collectors.toMap(e -> e.numberOfMatch, e -> e));
    private final int numberOfMatch;
    private final long prizeMoney;

    Prize(int numberOfMatch, long prizeMoney) {
        this.numberOfMatch = numberOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Prize fromNumberOfMatch(int number) {
        if (!PRIZE_MAP.containsKey(number)) {
            return Prize.NO_PRIZE;
        }
        return PRIZE_MAP.get(number);
    }

    public long calculatePrizeMoneyBy(int count) {
        return count * prizeMoney;
    }

    @Override
    public String toString() {
        return numberOfMatch + "개 일치 (" + prizeMoney + "원)-";
    }
}

