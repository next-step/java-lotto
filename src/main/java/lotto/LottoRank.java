package lotto;

import java.util.Arrays;

public enum LottoRank {
    UNRANK(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
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

    public static LottoRank fromMatchCount(int matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(UNRANK);

    }
}
