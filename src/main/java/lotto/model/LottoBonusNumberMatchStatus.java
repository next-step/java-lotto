package lotto.model;

public enum LottoBonusNumberMatchStatus {
    ANYWAY,
    UN_MATCH,
    MATCH;

    public static LottoBonusNumberMatchStatus createByMatchBonusNumber(final boolean isMatchedBonusNumber) {
        if (isMatchedBonusNumber) {
            return MATCH;
        }
        return UN_MATCH;
    }
}
