package step02.domain;

import java.util.Map;

public enum LottoGrade {

    FIRST(6, 2_000_000_000),

    SECOND(5, 1_500_000),

    THIRD(4, 50_000),

    FOURTH(3, 5_000),
    OTHER_GRADE(0, 0);

    private static final Map<Integer, LottoGrade> lottoGradePool = Map.of(
        6, FIRST,
        5, SECOND,
        4, THIRD,
        3, FOURTH,
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

    public static LottoGrade from(int rightCount) {
        LottoGrade lottoGrade = lottoGradePool.get(rightCount);
        if (lottoGrade == null) {
            throw new IllegalArgumentException("rightCount 값은  ~ 6 사이의 값이여야 합니다. rightCount: " + rightCount);
        }
        return lottoGrade;
    }
}
