package lottery.domain;

public class MatchedCountAndPrizePair {

    private final int matchedCount;
    private final long prize;

    private MatchedCountAndPrizePair(final int matchedCount, final long prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static MatchedCountAndPrizePair of(final int matchedCount, final long prize) {
        return new MatchedCountAndPrizePair(matchedCount, prize);
    }

    public int matchedCount() {
        return matchedCount;
    }

    public long prize() {
        return prize;
    }
}
