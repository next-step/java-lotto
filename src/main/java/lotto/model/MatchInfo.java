package lotto.model;

public class MatchInfo {

    private int matchCount;
    private boolean bonusMatch;

    public MatchInfo(int matchCount, boolean bonusMatch){
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
