package lotto;

import java.util.Objects;

public class MatchedCount {

    private final long count;

    public MatchedCount(long count) {
        this.count = count;
    }

    public boolean isEquals(int matchedCount) {
        return this.count == matchedCount;
    }

    public boolean isWin() {
        return this.count > 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchedCount)) return false;
        MatchedCount that = (MatchedCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
