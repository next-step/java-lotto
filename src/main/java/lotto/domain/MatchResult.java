package lotto.domain;

public class MatchResult {
    private final int matchCount;
    private final boolean bonusMatched;

    public MatchResult(int matchCount, boolean bonusMatched) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
    }

    public int matchCount() {
        return matchCount;
    }

    public boolean bonusMatched() {
        return bonusMatched;
    }
}
