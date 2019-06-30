package lotto.domain.winning;

import java.util.Arrays;

public enum LottoWinningAmount {
    NONE(0, 0, false),
    THREE_MATCH(3, 5_000, false),
    FOUR_MATCH(4, 50_000, false),
    FIVE_MATCH(5, 1_500_000, false),
    FIVE_AND_BONUS_MATCH(5, 30_000_000, true),
    SIX_MATCH(6, 2_000_000_000, false);

    private Integer matchCount;
    private Long winningAmount;
    private Boolean bonusMatch;

    LottoWinningAmount(int matchCount, long winningAmount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.bonusMatch = bonusMatch;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public static LottoWinningAmount find(long matchCount, boolean bonusMatch) {
        return Arrays.stream(LottoWinningAmount.values())
                .filter(amount -> isSameMatchCount(amount, matchCount) && isBonusCondition(amount, bonusMatch))
                .findFirst().orElse(NONE);
    }

    private static boolean isSameMatchCount(LottoWinningAmount amount, long matchCount) {
        return amount.matchCount == matchCount;
    }

    private static boolean isBonusCondition(LottoWinningAmount amount, boolean bonusMatch) {
        return amount.matchCount.equals(LottoWinningAmount.FIVE_AND_BONUS_MATCH.matchCount)
                && amount.bonusMatch == bonusMatch;

    }
}
