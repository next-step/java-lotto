package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    LottoRank(final int matchCount, final int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank from(final int matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public boolean isNoneRank() {
        return this == NONE;
    }

    public boolean hasRankedPrize(){
        return !isNoneRank();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize(){
        return prize;
    }
}
