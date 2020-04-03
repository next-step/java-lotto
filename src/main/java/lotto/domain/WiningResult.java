package lotto.domain;

public class WiningResult {
    private final int matchCount;
    private final boolean bonusMatch;

    public static WiningResult of(int matchCount, boolean bonusMatch) {
        return new WiningResult(matchCount, bonusMatch);
    }

    private WiningResult(int matchCount, boolean bonusMatch) {
        if (matchCount < 0) {
            throw new IllegalArgumentException();
        }
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
