package step2.domain;

public class MatchResult {
    private final Rank rank;

    public MatchResult(int matchedCount, boolean isBonusMatched) {
        this.rank = Rank.from(matchedCount, isBonusMatched);
    }

    public Rank getRank() {
        return rank;
    }
}
