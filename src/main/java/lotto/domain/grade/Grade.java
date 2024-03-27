package lotto.domain.grade;

import java.util.Arrays;
import lotto.domain.winning.WinningNumberResult;

public enum Grade {

    FIRST_GRADE(2_000_000_000, 6),
    BONUS_GRADE(30_000_000, 5),
    SECOND_GRADE(1_500_000, 5),
    THIRD_GRADE(50_000, 4),
    FOUR_GRADE(5_000, 3),
    UN_LUCKY_GRADE(0, 0);

    private final int prizeMoney;

    private final int correctingCount;

    Grade(int prizeMoney, int correctingCount) {
        this.prizeMoney = prizeMoney;
        this.correctingCount = correctingCount;
    }

    public static Grade fromMatchResult(WinningNumberResult winningNumberResult) {
        if (winningNumberResult.isBonusGrade()) {
            return BONUS_GRADE;
        }

        return Arrays.stream(Grade.values())
            .filter(grade -> grade != BONUS_GRADE)
            .filter(grade -> grade.isSameCorrectingCount(winningNumberResult.getMatchCount()))
            .findFirst()
            .orElse(Grade.UN_LUCKY_GRADE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCorrectingCount() {
        return correctingCount;
    }

    public boolean isSameCorrectingCount(final int other) {
        return correctingCount == other;
    }
}
