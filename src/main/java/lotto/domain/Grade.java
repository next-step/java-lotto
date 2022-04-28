package lotto.domain;

import java.util.Arrays;

public enum Grade {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private int fitCount;
    private int reward;

    Grade(int fitCount, int reward) {
        this.fitCount = fitCount;
        this.reward = reward;
    }

    public int getFitCount() {
        return fitCount;
    }

    public int getReward() {
        return this.reward;
    }

    public static Grade valueOf(int fitCount, boolean isFitBonusNumber) {
        Grade grade = Arrays.stream(Grade.values())
            .filter(gradeValue -> gradeValue.getFitCount() == fitCount)
            .findFirst().orElse(Grade.NONE);

        if (grade.equals(Grade.SECOND) && !isFitBonusNumber) {
            grade = Grade.THIRD;
        }

        return grade;
    }

    @Override
    public String toString() {
        return "Grade{" + this.name() + " " +
            "fitCount=" + fitCount +
            ", reward=" + reward +
            '}' + "\n";
    }
}
