package lotto.domain.grade;

import java.util.Arrays;
import lotto.error.exception.NotExistGradeException;

public enum Grade {

    FIRST_GRADE(2_000_000_000, 6),
    SECOND_GRADE(1_500_000, 5),
    THIRD_GRADE(50_000, 4),
    FOUR_GRADE(5_000, 3),
    UN_LUCKY_GRADE(0, 0);

    private int prizeMoney;

    private int correctingCount;

    Grade(int prizeMoney, int correctingCount) {
        this.prizeMoney = prizeMoney;
        this.correctingCount = correctingCount;
    }

    public static Grade fromCorrectingCount(int correctingCount) {
        return Arrays.stream(Grade.values())
            .filter(grade -> grade.isSameCorrectingCount(correctingCount))
            .findFirst()
            .orElse(Grade.UN_LUCKY_GRADE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCorrectingCount() {
        return correctingCount;
    }

    public boolean isSameCorrectingCount(int other) {
        return correctingCount == other;
    }
}
