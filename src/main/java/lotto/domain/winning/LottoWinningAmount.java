package lotto.domain.winning;

import java.util.Arrays;

public enum LottoWinningAmount {
    SIX_MATCH(6, 2_000_000_000, false),
    FIVE_AND_BONUS_MATCH(5, 30_000_000, true),
    FIVE_MATCH(5, 1_500_000, false),
    FOUR_MATCH(4, 50_000, false),
    THREE_MATCH(3, 5_000, false),
    NONE(0, 0, false);

    private int matchCount;
    private long winningAmount;
    private boolean bonusNumberMatch;

    LottoWinningAmount(int matchCount, long winningAmount, boolean bonusNumberMatch) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.bonusNumberMatch = bonusNumberMatch;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public boolean isWinningCondition(long matchCount, boolean bonusNumberMatch) {
        return isSameMatchCount(matchCount) && isBonusCondition(bonusNumberMatch);
    }

    private boolean isSameMatchCount(long matchCount) {
        return this.matchCount == matchCount;
    }

    private boolean isBonusCondition(boolean bonusNumberMatch) {
        return this.bonusNumberMatch ? bonusNumberMatch : true;
    }

    public static LottoWinningAmount find(long matchCount, boolean bonusNumberMatch) {
        return Arrays.stream(LottoWinningAmount.values())
                .filter(amount -> amount.isWinningCondition(matchCount, bonusNumberMatch))
                .findFirst().orElse(NONE);
    }
}
