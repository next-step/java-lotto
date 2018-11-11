package game.lotto.model;

public class Match {

    private int count;
    private MatchType matchType;

    public Match(MatchType matchType) {
        this.matchType = matchType;
    }

    public Match(Match match) {
        this.count = match.count;
        this.matchType = match.matchType;
    }

    public void plusCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }

    public MatchType getMatchType() {
        return this.matchType;
    }

    public long getTotalPrize() {
        return matchType.getTotalPrize(this.count);
    }
}
