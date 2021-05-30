package lotto.domain;

public class MatchStatusOfALotto {
    private int sameNumberCount = 0;
    private boolean isBonusWon = false;

    public MatchStatusOfALotto(int sameNumberCount, boolean isBonusWon) {
        this.sameNumberCount = sameNumberCount;
        this.isBonusWon = isBonusWon;
    }

    public ResultScoreEnum getResultScore() {
        ResultScoreEnum resultScoreEnum = ResultScoreEnum.valueOf(sameNumberCount, isBonusWon);
        return resultScoreEnum;
    }
}
