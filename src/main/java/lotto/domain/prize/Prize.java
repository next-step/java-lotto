package lotto.domain.prize;

import lotto.exception.ErrorMessage;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Prize {

    MISS(0, 0, (matchedNumbersCount, matchBonus) -> matchedNumbersCount < 3),
    FIFTH(3, 5_000, (matchedNumbersCount, matchBonus) -> matchedNumbersCount == 3),
    FOURTH(4, 50_000, (matchedNumbersCount, matchBonus) -> matchedNumbersCount == 4),
    THIRD(5, 1_500_000, (matchedNumbersCount, matchBonus) -> matchedNumbersCount == 5 && !matchBonus),
    SECOND(5, 30_000_000, (matchedNumbersCount, matchBonus) -> matchedNumbersCount == 5 && matchBonus),
    FIRST(6, 2_000_000_000, (matchedNumbersCount, matchBonus) -> matchedNumbersCount == 6);

    private final int matchedNumbersCount;
    private final int prizeMoney;
    private final BiFunction<Integer, Boolean, Boolean> function;

    static final int MIN_MATCHED_COUNT = 0;
    static final int MAX_MATCHED_COUNT = 6;

    Prize(final int matchedNumbersCount, final int prizeMoney, final BiFunction<Integer, Boolean, Boolean> function) {
        this.matchedNumbersCount = matchedNumbersCount;
        this.prizeMoney = prizeMoney;
        this.function = function;
    }

    public static Prize of(final int matchedNumbersCount, final boolean matchBonus) {
        verifyMatchedNumbersCountRange(matchedNumbersCount);

        return Arrays.stream(Prize.values())
                .filter(prize -> prize.operate(matchedNumbersCount, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    private static void verifyMatchedNumbersCountRange(final int matchedNumbersCount) {
        if (matchedNumbersCount < MIN_MATCHED_COUNT || matchedNumbersCount > MAX_MATCHED_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_OF_PRIZE_COUNT);
        }
    }

    public boolean operate(final int matchedNumbersCount, final boolean matchBonus) {
        return function.apply(matchedNumbersCount, matchBonus);
    }

    public int getMatchedNumbersCount() {
        return matchedNumbersCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
