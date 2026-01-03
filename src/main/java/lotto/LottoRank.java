package lotto;

import java.util.Arrays;

public enum LottoRank {
    UNRANK(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;

    LottoRank(int matchCount, boolean matchBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public int matchCount() {
        return matchCount;
    }

    public int prizeMoney() {
        return prizeMoney;
    }

    public boolean isNoRank() {
        return this == UNRANK;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount && !rank.matchBonus)
                .findFirst()
                .orElse(UNRANK);
    }
}
