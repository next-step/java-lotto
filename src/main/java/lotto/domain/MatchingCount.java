package lotto.domain;

import java.util.Objects;

public final class MatchingCount {

    private static final int INIT = 0;
    private static final int ADD = 1;

    private final int matchingCount;

    public MatchingCount() {
        this(INIT);
    }

    public MatchingCount(final int matchingCount) {
        this.matchingCount = matchingCount;
    }

    public int getMatchingCount() {
        return this.matchingCount;
    }

    public MatchingCount addMatchingCount() {
        return new MatchingCount(this.matchingCount + ADD);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchingCount that = (MatchingCount) o;
        return matchingCount == that.matchingCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchingCount);
    }

}
