package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 3_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    LAST(0, 0, 0);

    private final int matchCount;
    private final int bonusCount;
    private final int prize;

    LottoRank(int matchCount, int bonusCount, int prize) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getTotalPrize(int count) {
        return prize * count;
    }

    public static LottoRank of(int matchCount, int bonusCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount
                        && (rank.bonusCount == bonusCount || rank.bonusCount < bonusCount))
                .findFirst()
                .orElse(LAST);
    }

}
