package lotto.domain;

import java.util.Arrays;

public class LottoResult {

    private Grade grade;

    private LottoResult(int fitCount) {
        this.grade = Arrays.stream(Grade.values())
            .filter(gradeValue -> gradeValue.getFitCount() == fitCount)
            .findFirst().orElse(Grade.NONE);
    }

    public static LottoResult of(int fitCount) {
        return new LottoResult(fitCount);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
            "grade=" + grade +
            '}';
    }

    public int fitCount() {
        return grade.getFitCount();
    }

    public int reward() {
        return grade.getReward();
    }
}

