package lotto.domain.prize;

import java.util.Objects;

public class MatchInfo {
    private final int matchCount;
    private final boolean bonusMatch;

    private MatchInfo(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public static MatchInfo of(int matchCount, boolean bonusMatch) {
        return new MatchInfo(matchCount, bonusMatch);
    }

    public boolean isBonusNumberMatch() {
        return bonusMatch;
    }

    public boolean isEqualCount(int count) {
        return matchCount == count;
    }

    public boolean isUnderCount(int count) {
        return matchCount < count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchInfo matchInfo = (MatchInfo) o;
        return matchCount == matchInfo.matchCount && bonusMatch == matchInfo.bonusMatch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, bonusMatch);
    }
}
