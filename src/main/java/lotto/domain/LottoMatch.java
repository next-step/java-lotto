package lotto.domain;

import java.util.Objects;

public class LottoMatch {
    private final int matchCount;
    private final boolean isBonusMatch;

    public LottoMatch(int matchCount, boolean isBonusMatch) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMatch that = (LottoMatch) o;
        return matchCount == that.matchCount && isBonusMatch == that.isBonusMatch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, isBonusMatch);
    }
}
