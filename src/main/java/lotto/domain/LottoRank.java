package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0,0);


    private final int matchCount;
    private final long prizeMoney;

    LottoRank(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank valueOfMatchCount(int matchCount) {
        return Arrays.stream(values())
            .filter(rank -> rank.matchCount == matchCount)
            .findAny()
            .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }
    public long getPrizeMoney() {
        return prizeMoney;
    }
}
