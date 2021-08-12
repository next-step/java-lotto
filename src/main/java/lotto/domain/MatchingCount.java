package lotto.domain;

import lotto.domain.exception.HitsRangeException;

import java.util.Objects;

public final class MatchingCount {

    private static final int INIT = 0;
    private static final int ADD = 1;
    private static final int MIN_HITS_COUNT = 0;
    private static final int MAX_HITS_COUNT = 6;

    private final int matchingCount;

    public MatchingCount() {
        this(INIT);
    }

    public MatchingCount(final int matchingCount) {
        validateMatchingCount(matchingCount);
        this.matchingCount = matchingCount;
    }

    private void validateMatchingCount(final int matchingCount) {
        if (matchingCount < MIN_HITS_COUNT || matchingCount > MAX_HITS_COUNT) {
            throw new HitsRangeException();
        }
    }

    public boolean isSameValue(int count) {
        return this.matchingCount == count;
    }

    public boolean isLowerValue(int count) {
        return this.matchingCount < count;
    }

    public MatchingCount increment() {
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
