package lotto.model;

import lotto.model.wrapper.LottoMatchCount;

public enum LottoBonusMatchResult {
    ANYWAY,
    UN_MATCH,
    MATCH;

    public static LottoBonusMatchResult of(final LottoMatchCount matchCount, final boolean matchBonusNumber) {
        if (matchCount == LottoMatchCount.BONUS_CHECK_COUNT) {
            return createByMatchBonusNumber(matchBonusNumber);
        }
        return ANYWAY;
    }

    private static LottoBonusMatchResult createByMatchBonusNumber(final boolean matchBonusNumber) {
        if (matchBonusNumber) {
            return MATCH;
        }
        return UN_MATCH;
    }
}
