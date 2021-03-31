package lotto.domain;

import java.util.Objects;

public class MatchedCount {
    private final int matchedCount;

    public MatchedCount(int matchedCount) {
        this.matchedCount = matchedCount;
    }

    public int matchedCount() {
        return matchedCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchedCount that = (MatchedCount) o;
        return matchedCount == that.matchedCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchedCount);
    }
}
