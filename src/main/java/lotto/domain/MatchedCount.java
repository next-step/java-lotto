package lotto.domain;

import java.util.Objects;

public class MatchedCount {
    private static final int BOUND_MIN = 1;
    private static final int BOUND_MAX = 6;
    private static final String CHECK_BOUND = String.format("매칭된 개수는 %d ~ %d의 범위여야 합니다.", BOUND_MIN, BOUND_MAX);
    private final int matchedCount;

    public MatchedCount() {
        this(BOUND_MIN);
    }

    public MatchedCount(long matchedCount) {
        this((int) matchedCount);
    }

    public MatchedCount(int matchedCount) {
        validateBound(matchedCount);
        this.matchedCount = matchedCount;
    }

    private void validateBound(int matchedCount) {
        if (BOUND_MIN > matchedCount || matchedCount > BOUND_MAX) {
            throw new IllegalArgumentException(CHECK_BOUND);
        }
    }

    public int matchedCount() {
        return matchedCount;
    }

    public boolean isGreaterOrEqualThan(MatchedCount matchedCount) {
        return !matchedCount.isGreaterOrEqualThan(this.matchedCount);
    }

    public boolean isGreaterOrEqualThan(int matchedCount) {
        return this.matchedCount >= matchedCount;
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
