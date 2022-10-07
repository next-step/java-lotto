package step02.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoGrade {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),

    THIRD(5, false, 1_500_000),

    FOURTH(4, false, 50_000),

    FIFTH(3, false, 5_000),

    OTHER_GRADE(0, false, 0);

    private final int rightCount;
    private final int winnings;
    private final boolean isMustBonus;

    LottoGrade(int rightCount, boolean isMustBonus, int winnings) {
        this.rightCount = rightCount;
        this.isMustBonus = isMustBonus;
        this.winnings = winnings;
    }

    public static LottoGrade from(int rightCount, boolean bonusMatch) {
        validateRightCountRange(rightCount);

        return Arrays.stream(values())
            .sorted(Comparator.comparing(LottoGrade::isMustBonus, Comparator.reverseOrder()))
            .filter(lottoGrade -> equalsRightCount(lottoGrade, rightCount) && satisfyingBonusMatch(lottoGrade, bonusMatch))
            .findFirst()
            .orElse(OTHER_GRADE);
    }

    private static void validateRightCountRange(int rightCount) {
        if (rightCount < 0 || rightCount > 6) {
            throw new IllegalArgumentException("rightCount 값은 0 ~ 6 사이의 값이여야 합니다. rightCount: " + rightCount);
        }
    }

    private static boolean equalsRightCount(LottoGrade lottoGrade, int rightCount) {
        return lottoGrade.getRightCount() == rightCount;
    }

    private static boolean satisfyingBonusMatch(LottoGrade lottoGrade, boolean bonusMatch) {
        return !lottoGrade.isMustBonus || bonusMatch;
    }

    public int getRightCount() {
        return rightCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public boolean isMustBonus() {
        return isMustBonus;
    }
}
