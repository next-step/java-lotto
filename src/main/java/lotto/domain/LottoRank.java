package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int prize;
    private final boolean isCheckBonusNumber;

    LottoRank(final int matchCount, final int prize, final boolean isCheckBonusNumber) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.isCheckBonusNumber = isCheckBonusNumber;
    }
    
    public static LottoRank from(final int matchCount, final boolean isCheckBonusNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount
                        && rank.isCheckBonusNumber == isCheckBonusNumber)
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
