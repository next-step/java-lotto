package step3.domain;

public class MatchCondition {
    private final int matchCount;
    private final boolean matchBonus;

    public MatchCondition(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public int matchCount() {
        return matchCount;
    }

    public boolean matchBonus() {
        return matchBonus;
    }
}
