package lotto.domain;

public class MatchResult {

    private int matchCount;

    private boolean matchBonusBall;

    public MatchResult(int matchCount, boolean matchBonusBall) {
        this.matchCount = matchCount;
        this.matchBonusBall = matchBonusBall;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonusBall() {
        return matchBonusBall;
    }
}
