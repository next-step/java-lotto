package lotto.model;

public enum LottoBonusNumberMatch {
    ANYWAY,
    UN_MATCH,
    MATCH;

    public static LottoBonusNumberMatch createByMatchBonusNumber(final boolean isMatchedBonusNumber) {
        if (isMatchedBonusNumber) {
            return MATCH;
        }
        return UN_MATCH;
    }
}
