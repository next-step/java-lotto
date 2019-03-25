package lottogame.domain;

public class MatchStatus {

    private final int matchedCount;
    private final boolean bonusNumberMatched;

    public MatchStatus(int matchedCount, boolean bonusNumberMatched) {
        this.matchedCount = matchedCount;
        this.bonusNumberMatched = bonusNumberMatched;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusNumberMatched() {
        return bonusNumberMatched;
    }
}