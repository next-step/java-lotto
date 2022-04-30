package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Grade {
    FIRST(6, 2_000_000_000,false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000,  false),
    FIFTH(3, 5_000,  false),
    NONE(0, 0, false);

    private final int fitCount;
    private final int reward;
    private final boolean fitBonusNumber;

    Grade(int fitCount, int reward, Boolean fitBonusNumber) {
        this.fitCount = fitCount;
        this.reward = reward;
        this.fitBonusNumber = fitBonusNumber;
    }

    public int getFitCount() {
        return fitCount;
    }

    public int getReward() {
        return this.reward;
    }

    public boolean isFitBonusNumber() {
        return fitBonusNumber;
    }

    public static Grade valueOf(int fitCount, boolean isFitBonusNumber) {
        List<Grade> grades = Arrays.stream(Grade.values())
            .filter(gradeValue -> gradeValue.getFitCount() == fitCount)
            .collect(Collectors.toList());

        if (grades.size() < 2) {
            return grades.stream()
                .findFirst().orElse(Grade.NONE);
        }

        return grades.stream()
            .filter(grade -> grade.isFitBonusNumber() == isFitBonusNumber)
            .findFirst().orElse(Grade.NONE);
    }

    @Override
    public String toString() {
        return "Grade{" + this.name() + " " +
            "fitCount=" + fitCount +
            ", reward=" + reward +
            '}' + "\n";
    }
}
