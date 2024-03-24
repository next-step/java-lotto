package lotto;

import java.util.Objects;

public class MatchedCount {

    private final long count;
    private final boolean isBonus;

    public MatchedCount(long count) {
        this(count, false);
    }

    public MatchedCount(long count, boolean isBonus) {
        this.count = count;
        this.isBonus = isBonus;
    }

    public boolean isEquals(int matchedCount) {
        return this.count == matchedCount && !isBonus;
    }

    public boolean isWin() {
        return this.count > 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchedCount)) return false;
        MatchedCount that = (MatchedCount) o;
        return count == that.count && isBonus == that.isBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, isBonus);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
