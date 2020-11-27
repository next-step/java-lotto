package lotto.domain;

import java.util.Objects;

public class MatchStatus {

    private int matchCount;
    private boolean isBonusball;

    public MatchStatus(int matchCount, boolean isBonusball) {
        this.matchCount = matchCount;
        this.isBonusball = isBonusball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchStatus that = (MatchStatus) o;
        return matchCount == that.matchCount &&
                isBonusball == that.isBonusball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, isBonusball);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void notAllowedBallOtherNumber(int availableNumber) {
        if(matchCount != availableNumber){
            this.isBonusball = false;
        }
    }
}
