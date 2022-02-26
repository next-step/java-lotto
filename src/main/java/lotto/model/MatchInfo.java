package lotto.model;

public class MatchInfo {

    private final int matchCount;
    private final boolean bonusMatch;

    public MatchInfo(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }
}
