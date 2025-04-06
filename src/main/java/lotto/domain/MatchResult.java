package lotto.domain;

import java.util.Objects;

public class MatchResult {
    private final int matchCount;
    private final boolean isBonusMatch;

    public MatchResult(int matchCount, boolean isBonusMatch) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchResult that = (MatchResult) o;
        return matchCount == that.matchCount && isBonusMatch == that.isBonusMatch;
    }

    @Override
    public int hashCode() {
        int result = matchCount;
        result = 31 * result + Objects.hashCode(isBonusMatch);
        return result;
    }
}
