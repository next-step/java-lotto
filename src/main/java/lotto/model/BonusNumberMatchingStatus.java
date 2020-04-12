package lotto.model;

public enum BonusNumberMatchingStatus {
    ANYWAY,
    UN_MATCH,
    MATCH;

    public static BonusNumberMatchingStatus createByMatchBonusNumber(final boolean isMatchedBonusNumber) {
        if (isMatchedBonusNumber) {
            return MATCH;
        }
        return UN_MATCH;
    }
}
