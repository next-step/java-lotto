package lotto.domain;

public class MatchResult {
    private final int matchCount;
    private final int matchBonus;

    public MatchResult(int matchCount, int matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMatchBonus() {
        return matchBonus;
    }
}
