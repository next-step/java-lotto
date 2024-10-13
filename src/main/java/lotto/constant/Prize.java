package lotto.constant;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Prize {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    MISS(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    Prize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public static Prize calculateRank(int count, boolean isBonusMatch) {
        return Arrays.stream(values())
                .filter(p -> p.matchCount == count)
                .findFirst()
                .map(p -> {
                    if (p == THIRD || p == SECOND) {
                        return isBonusMatch ? SECOND : THIRD;
                    }
                    return p;
                })
                .orElse(MISS);
    }

}
