package lotto.domain.winning;

import lotto.common.PositiveNumber;

import java.util.Arrays;

public enum LottoWinningAmount {
    SIX_MATCH(6, 2_000_000_000, false),
    FIVE_AND_BONUS_MATCH(5, 30_000_000, true),
    FIVE_MATCH(5, 1_500_000, false),
    FOUR_MATCH(4, 50_000, false),
    THREE_MATCH(3, 5_000, false),
    NONE(0, 0, false);

    private long matchCount;
    private long winningAmount;
    private boolean bonusNumberMatch;

    LottoWinningAmount(long matchCount, long winningAmount, boolean bonusNumberMatch) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.bonusNumberMatch = bonusNumberMatch;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public boolean isWinningCondition(PositiveNumber matchCount, boolean bonusNumberMatch) {
        return isSameMatchCount(matchCount) && isBonusCondition(bonusNumberMatch);
    }

    private boolean isSameMatchCount(PositiveNumber matchCount) {
        return this.matchCount == matchCount.get();
    }

    private boolean isBonusCondition(boolean bonusNumberMatch) {
        return this.bonusNumberMatch ? bonusNumberMatch : true;
    }

    public static LottoWinningAmount find(PositiveNumber matchCount, boolean bonusNumberMatch) {
        return Arrays.stream(LottoWinningAmount.values())
                .filter(amount -> amount.isWinningCondition(matchCount, bonusNumberMatch))
                .findFirst().orElse(NONE);
    }
}
