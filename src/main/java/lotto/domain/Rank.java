package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000L),
    SECOND_WITH_BONUS(5, 30_000_000L),
    SECOND(5, 1_500_000L),
    THIRD(4, 50_000L),
    FOURTH(3, 5_000L),
    MISS(0, 0L);

    private final int matchedCount;
    private final long winnerPrize;

    Rank(int matchedCount, long winnerPrize) {
        this.matchedCount = matchedCount;
        this.winnerPrize = winnerPrize;
    }

    public static Rank valueOf(final int matchedCount, final boolean withBonus) {
        Rank result = Arrays.stream(Rank.values())
            .filter(rank -> rank.matchedCount == matchedCount)
            .findFirst()
            .orElse(MISS);
        if(SECOND_WITH_BONUS == result && !withBonus){
            return SECOND;
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
}
