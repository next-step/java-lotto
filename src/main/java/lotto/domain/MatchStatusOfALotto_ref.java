package lotto.domain;

public class MatchStatusOfALotto_ref {
    private int sameNumberCount = 0;
    private boolean isBonusWon = false;

    public MatchStatusOfALotto_ref(int sameNumberCount, boolean isBonusWon) {
        this.sameNumberCount = sameNumberCount;
        this.isBonusWon = isBonusWon;
    }

    public ResultScoreEnum_ref getResultScore() {
        ResultScoreEnum_ref resultScoreEnum = ResultScoreEnum_ref.valueOf(sameNumberCount, isBonusWon);
        return resultScoreEnum;
    }
}
