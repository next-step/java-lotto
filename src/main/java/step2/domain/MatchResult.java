package step2.domain;

public class MatchResult {
    private final Rank rank;

    public MatchResult(int matchedCount) {
        this.rank = Rank.from(matchedCount);
    }

    public Rank getRank() {
        return rank;
    }
}
