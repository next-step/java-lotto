package lotto.domain;

import java.util.Objects;

public class MatchStatus {

    private static final int BONUS_BALL_MATCH_COUNT = 5;

    private int matchCount;
    private boolean isBonusball;

    private MatchStatus(int matchCount, boolean isBonusball) {
        this.matchCount = matchCount;
        this.isBonusball = isBonusball;
    }

    public static MatchStatus of(int matchCount, boolean isBonusball) {
        if(matchCount != BONUS_BALL_MATCH_COUNT){
            return new MatchStatus(matchCount, false);
        }
        return new MatchStatus(matchCount, isBonusball);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusball() {
        return isBonusball;
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
}
