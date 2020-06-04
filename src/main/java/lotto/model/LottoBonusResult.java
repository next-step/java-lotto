package lotto.model;

public enum LottoBonusResult {
    NOTHING,
    NOT_MATCHED,
    MATCHED;

    private final static int BONUS_CHECK_COUNT = 5;

    public static LottoBonusResult of(int matchCount, boolean isMatchBonusNumber) {
        if(matchCount == BONUS_CHECK_COUNT) {
            return createByMatchBonusNumber(isMatchBonusNumber);
        }

        return NOTHING;
    }

    private static LottoBonusResult createByMatchBonusNumber(boolean isMatchBonusNumber) {
        if(isMatchBonusNumber) {
            return MATCHED;
        }

        return NOT_MATCHED;
    }
}
