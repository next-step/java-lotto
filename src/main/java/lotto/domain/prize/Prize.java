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

    private static final Map<Integer, Prize> PRIZES = Arrays.stream(Prize.values())
            .collect(Collectors.toMap(Prize::getMatchedNumbersCount, Function.identity()));

    Prize(final int matchedNumbersCount, final int prizeMoney) {
        this.matchedNumbersCount = matchedNumbersCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize of(final int matchedNumbersCount) {
        if (!PRIZES.containsKey(matchedNumbersCount)) {
            throw new IllegalArgumentException(String.format(ErrorMessage.NOT_MATCHED_COUNT_OF_PRIZE, matchedNumbersCount));
        }
        return PRIZES.get(matchedNumbersCount);
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
