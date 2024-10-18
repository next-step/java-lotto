package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    BONUS_MATCHES(5, 30_000_000),
    SIX_MATCHES(6, 2_000_000_000),
    NO_MATCH(0, 0);

    private final int matchCount;
    private final int prizeMoney;
    private int count;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.count = 0;
    }

    public static LottoRank valueOfMatchCount(int matchCount, boolean bonusMatched) {
        if (matchCount == 5 && bonusMatched) {
            return BONUS_MATCHES;
        }

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != BONUS_MATCHES && rank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NO_MATCH);
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
}
