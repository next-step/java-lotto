package lotto.domain.number;

public class MatchResult {

    private final int matchCount;

    private final boolean bonusMatch;

    public MatchResult(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean getBonusMatch() {
        return this.bonusMatch;
    }

}
