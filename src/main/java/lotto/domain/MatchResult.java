package lotto.domain;

public class MatchResult {
    private final int matchCount;
    private final boolean isBonus;

    public MatchResult(int matchCount, boolean isBonus) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
    }

    public int matchCount() {
        return this.matchCount;
    }

    public boolean isBonus() {
        return this.isBonus;
    }
}
