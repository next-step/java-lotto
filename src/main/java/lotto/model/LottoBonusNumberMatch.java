package lotto.model;

import lotto.model.wrapper.WinningLottoMatchingCount;

public enum LottoBonusNumberMatch {
    ANYWAY,
    UN_MATCH,
    MATCH;

    public static LottoBonusNumberMatch of(final WinningLottoMatchingCount matchCount, final boolean matchBonusNumber) {
        if (matchCount == WinningLottoMatchingCount.BONUS_CHECK_COUNT) {
            return createByMatchBonusNumber(matchBonusNumber);
        }
        return ANYWAY;
    }

    private static LottoBonusNumberMatch createByMatchBonusNumber(final boolean matchBonusNumber) {
        if (matchBonusNumber) {
            return MATCH;
        }
        return UN_MATCH;
    }
}
