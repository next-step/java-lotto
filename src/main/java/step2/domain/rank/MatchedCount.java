package step2.domain.rank;

public class MatchedCount {
    private final int matchedCount;

    public MatchedCount(int matchedCount) {
        this.matchedCount = matchedCount;
    }

    public boolean isSame(int number) {
        return matchedCount == number;
    }
}
