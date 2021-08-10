package lotto.domain;

import java.util.Objects;

public final class MatchingCount {

    private static final int INIT = 0;
    private static final int ADD = 1;
    private static final int MIN_HITS_COUNT = 0;
    private static final int MAX_HITS_COUNT = 6;
    private static final String OUT_OF_BOUNDS_ERROR_MESSAGE = "맞춘 횟수는 0에서 6 사이여야 합니다.";

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
            throw new IllegalArgumentException(OUT_OF_BOUNDS_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return this.matchingCount;
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
