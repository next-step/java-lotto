package lotto.model;

public class MatchResult {
    private final int matchCount;

    private final boolean matchBonus;

    public MatchResult(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
