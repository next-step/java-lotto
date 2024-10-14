package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    SIX_MATCHES(6, 2000000000),
    NO_MATCH(0, 0);

    private final int matchCount;
    private final int prizeMoney;
    private int count;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.count = 0;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }

    public static LottoRank valueOfMatchCount(int matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NO_MATCH);
    }
}
