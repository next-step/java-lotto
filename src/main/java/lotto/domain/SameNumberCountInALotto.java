package lotto.domain;

public class SameNumberCountInALotto {
    private int sameNumberCount = 0;
    private boolean isBonusWon = false;

    public SameNumberCountInALotto(int sameNumberCount, boolean isBonusWon) {
        this.sameNumberCount = sameNumberCount;
        this.isBonusWon = isBonusWon;
    }

    public ResultScoreEnum getResultScore() {
        ResultScoreEnum resultScoreEnum = ResultScoreEnum.valueOf(sameNumberCount, isBonusWon);
        return resultScoreEnum;
    }
}
