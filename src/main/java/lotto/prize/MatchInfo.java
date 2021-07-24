package lotto.prize;

public class MatchInfo {
    private final int matchCount;
    private final boolean bonusMatch;

    private MatchInfo(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public static MatchInfo of(int matchCount, boolean bonusMatch) {
        return new MatchInfo(matchCount, bonusMatch);
    }
}
