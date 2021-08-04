package lotto.prize;

public class MatchInformation {
    private final int matchCount;
    private final boolean matchBonus;

    private MatchInformation(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public static MatchInformation of(int matchCount, boolean matchBonus) {
        return new MatchInformation(matchCount, matchBonus);
    }

    public boolean isMatchCountEq(final int matchCount) {
        return this.matchCount == matchCount;
    }

    public boolean isMatchCountNone(final int matchCount) {
        return this.matchCount <= matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
