package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public enum LottoRank {
    FIRST(1, 6, (matchedCount, matchBonus) -> matchedCount == 6,2_000_000_000),
    SECOND(2, 5, (matchedCount, matchBonus) -> matchedCount == 5 && matchBonus,30_000_000),
    THIRD(3, 5, (matchedCount, matchBonus) -> matchedCount == 5 && !matchBonus,1_500_000),
    FOURTH(4, 4, (matchedCount, matchBonus) -> matchedCount == 4,50_000),
    FIFTH(5, 3, (matchedCount, matchBonus) -> matchedCount == 3,5_000),
    LAST(6, 0, (matchedCount, matchBonus) -> matchedCount < 3,0);

    private static final String ERR_INVALID_MATCH_COUNT = "The number of matched lotto numbers cannot exceed 6, as there are a total of 6 lotto numbers.";
    private static final String ERR_INVALID_RANK = "Invalid rank";
    private final int rank;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> condition;
    private final int cashPrize;

    LottoRank(int rank, int matchCount, BiPredicate<Integer, Boolean> condition, int cash) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.condition = condition;
        this.cashPrize = cash;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.condition.test(matchCount, matchBonus))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_MATCH_COUNT));
    }

    public static LottoRank getByRank(int rank) {
        return Arrays.stream(values())
                .filter(element -> element.rank() == rank)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_RANK));
    }

    public boolean isSecondRank() {
        return this == LottoRank.SECOND;
    }

    public int rank() {
        return this.rank;
    }

    public int matchCount() {
        return this.matchCount;
    }

    public int cashPrize() {
        return this.cashPrize;
    }
}
