package step2.domain.rank;

public class MatchedCount {
    private final int matchedCount;

    public MatchedCount(int matchedCount) {
        this.matchedCount = matchedCount;
    }

    public boolean isSame(int number) {
        return matchedCount == number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(matchedCount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof MatchedCount))
            return false;

        MatchedCount other = (MatchedCount) obj;

        return matchedCount == other.matchedCount;
    }
}
