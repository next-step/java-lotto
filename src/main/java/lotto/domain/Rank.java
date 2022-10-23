package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    MISS(0, 0L);

    private final int matchedCount;
    private final long winnerPrize;

    Rank(int matchedCount, long winnerPrize) {
        this.matchedCount = matchedCount;
        this.winnerPrize = winnerPrize;
    }

    public static Rank valueOf(final int matchedCount, final boolean hasBonus) {
        return Arrays.stream(Rank.values())
            .filter(rank -> rank.matchedCount == matchedCount)
            .map(rank -> checkBonus(hasBonus, rank))
            .findFirst()
            .orElse(MISS);
    }

    private static Rank checkBonus(boolean hasBonus, Rank result) {
        if (SECOND == result && !hasBonus) {
            return THIRD;
        }
        return result;
    }

    public static BigDecimal sumPrize(List<Rank> ranks) {
        long result = 0L;
        for (Rank rank : ranks) {
            result += rank.winnerPrize;
        }
        return BigDecimal.valueOf(result);
    }

    public boolean isFirst() {
        return this == FIRST;
    }

    public boolean isSecond() {
        return this == SECOND;
    }

    public boolean isThird() {
        return this == THIRD;
    }

    public boolean isFourth() {
        return this == FOURTH;
    }

    public boolean isFifth() {
        return this == FIFTH;
    }
}
