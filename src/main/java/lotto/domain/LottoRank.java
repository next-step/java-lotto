package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;

public enum LottoRank {
    FIRST(1, 2_000_000_000, 6),
    SECOND(2, 30_000_000, 6),
    THIRD(3, 1_500_000, 5),
    FOURTH(4, 50_000, 4),
    FIFTH(5, 5_000, 3),
    NONE(0, 0, 0);

    private final int matchRank;
    private final int prizeMoney;
    private final int matchCount;

    LottoRank(int matchRank, int prizeMoney, int matchCount) {
        this.matchRank = matchRank;
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
    }

    public int getMatchRank() {
        return matchRank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoRank matchRank(int matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter(it -> it.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static EnumMap<LottoRank, Integer> initializePrizeCount() {
        EnumMap<LottoRank, Integer> prizeCount = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            prizeCount.put(rank, 0);
        }
        return prizeCount;
    }
}
