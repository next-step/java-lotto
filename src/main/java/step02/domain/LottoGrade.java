package step02.domain;

import java.util.Map;

public enum LottoGrade {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),

    THIRD(5, 1_500_000),

    FOURTH(4, 50_000),

    FIFTH(3, 5_000),

    OTHER_GRADE(0, 0);

    private static final Map<Integer, LottoGrade> lottoGradePool = Map.of(
        6, FIRST,
        5, THIRD,
        4, FOURTH,
        3, FIFTH,
        2, OTHER_GRADE,
        1, OTHER_GRADE,
        0, OTHER_GRADE
    );

    private final int rightCount;
    private final int winnings;

    LottoGrade(int rightCount, int winnings) {
        this.rightCount = rightCount;
        this.winnings = winnings;
    }

    public int getRightCount() {
        return rightCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public static LottoGrade from(int rightCount, boolean bonusMatch) {
        if (rightCount == 5 && bonusMatch) {
            return SECOND;
        }

        LottoGrade lottoGrade = lottoGradePool.get(rightCount);
        if (lottoGrade == null) {
            throw new IllegalArgumentException("rightCount 값은 0 ~ 6 사이의 값이여야 합니다. rightCount: " + rightCount);
        }
        return lottoGrade;
    }
}
