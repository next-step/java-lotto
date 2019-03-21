package lottogame.domain;

public class MatchStatus {

    final private int matchedCount;
    final private boolean bonusNumberMatched;

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