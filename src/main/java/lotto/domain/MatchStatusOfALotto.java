package lotto.domain;

import java.util.Objects;

public class MatchStatusOfALotto {
    private int sameNumberCount = 0;
    private boolean isBonusWon = false;

    public MatchStatusOfALotto(int sameNumberCount, boolean isBonusWon) {
        this.sameNumberCount = sameNumberCount;
        this.isBonusWon = isBonusWon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchStatusOfALotto that = (MatchStatusOfALotto) o;
        return sameNumberCount == that.sameNumberCount && isBonusWon == that.isBonusWon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sameNumberCount, isBonusWon);
    }

    public ResultScoreEnum getResultScore() {
        ResultScoreEnum resultScoreEnum = ResultScoreEnum.valueOf(sameNumberCount, isBonusWon);
        return resultScoreEnum;
    }
}
