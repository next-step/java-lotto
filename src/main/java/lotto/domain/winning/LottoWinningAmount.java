package lotto.domain.winning;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoWinningAmount {
    NONE(0, 0, BonusMatch.NONE),
    THREE_MATCH(3, 5_000, BonusMatch.NONE),
    FOUR_MATCH(4, 50_000, BonusMatch.NONE),
    FIVE_MATCH(5, 1_500_000, BonusMatch.NOT_MATCH),
    FIVE_AND_BONUS_MATCH(5, 30_000_000, BonusMatch.MATCH),
    SIX_MATCH(6, 2_000_000_000, BonusMatch.NONE);

    private Integer matchCount;
    private Long winningAmount;
    private BonusMatch bonusMatch;

    LottoWinningAmount(int matchCount, long winningAmount, BonusMatch bonusMatch) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.bonusMatch = bonusMatch;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public static LottoWinningAmount find(long matchCount, boolean bonusNumberMatch) {
        return Arrays.stream(LottoWinningAmount.values())
                .filter(amount -> isWinningCondition(amount, matchCount, bonusNumberMatch))
                .findFirst().orElse(NONE);
    }

    private static boolean isWinningCondition(LottoWinningAmount amount, long matchCount, boolean bonusNumberMatch) {
        return amount.matchCount == matchCount && amount.bonusMatch.match(bonusNumberMatch);
    }

    private enum BonusMatch {
        NONE(match -> true), MATCH(match -> match == true), NOT_MATCH(match -> match == false);

        private Function<Boolean, Boolean> expr;

        BonusMatch(Function<Boolean, Boolean> expr) {
            this.expr = expr;
        }

        public boolean match(boolean bonusMatch) {
            return expr.apply(bonusMatch);
        }
    }
}
