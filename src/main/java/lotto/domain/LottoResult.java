package lotto.domain;

public class LottoResult {

    private Grade grade;

    private LottoResult(int fitCount, boolean isFitBonusNumber) {
        this.grade = Grade.valueOf(fitCount, isFitBonusNumber);
    }

    public static LottoResult of(int fitCount, boolean isFitBonusNumber) {
        return new LottoResult(fitCount, isFitBonusNumber);
    }

    public int fitCount() {
        return grade.getFitCount();
    }

    public int reward() {
        return grade.getReward();
    }
}

