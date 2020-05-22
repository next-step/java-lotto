package lotto.domain.prize;

import lotto.exception.ErrorMessage;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Prize {

    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matchedNumbersCount;
    private final int prizeMoney;

    static final int MIN_MATCHED_COUNT = 0;
    static final int MAX_MATCHED_COUNT = 6;
    private static final Map<Integer, Prize> PRIZES = Arrays.stream(Prize.values())
            .collect(Collectors.toMap(Prize::getMatchedNumbersCount, Function.identity()));

    Prize(final int matchedNumbersCount, final int prizeMoney) {
        this.matchedNumbersCount = matchedNumbersCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize of(final int matchedNumbersCount) {
        validateMatchedNumbersCount(matchedNumbersCount);
        if (!PRIZES.containsKey(matchedNumbersCount)) {
            return Prize.MISS;
        }
        return PRIZES.get(matchedNumbersCount);
    }

    private static void validateMatchedNumbersCount(final int matchedNumbersCount) {
        if (matchedNumbersCount < MIN_MATCHED_COUNT || matchedNumbersCount > MAX_MATCHED_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_OF_PRIZE_COUNT);
        }
    }

    private int getMatchedNumbersCount() {
        return matchedNumbersCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", matchedNumbersCount, prizeMoney);
    }
}
