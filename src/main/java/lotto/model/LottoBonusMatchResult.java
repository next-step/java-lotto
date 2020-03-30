package lotto.model;

public enum LottoBonusMatchResult {
    ANYWAY,
    UN_MATCH,
    MATCH;

    private final static int BONUS_MUST_CHECK_COUNT = 5;

    public static LottoBonusMatchResult of(final int matchCount, final boolean matchBonusNumber) {
        if (matchCount == BONUS_MUST_CHECK_COUNT) {
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
