package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;

public enum LottoRank {
    FIRST(1, 2_000_000_000, 6, false),
    SECOND(2, 30_000_000, 5, true),
    THIRD(3, 1_500_000, 5, false),
    FOURTH(4, 50_000, 4, false),
    FIFTH(5, 5_000, 3, false),
    NONE(0, 0, 0, false);

    private final int matchRank;
    private final int prizeMoney;
    private final int matchCount;
    private final boolean matchBonus;

    LottoRank(int matchRank, int prizeMoney, int matchCount, boolean matchBonus) {
        this.matchRank = matchRank;
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
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

    public static LottoRank matchRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount && (!rank.matchBonus || matchBonus))
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
