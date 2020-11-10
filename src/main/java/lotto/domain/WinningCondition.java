package lotto.domain;

public class WinningCondition {
    private final int matchedCount;
    private final boolean bonusNumMatched;

    private WinningCondition(int matchedCount, boolean bonusNumMatched) {
        this.matchedCount = matchedCount;
        this.bonusNumMatched = bonusNumMatched;
    }

    public static WinningCondition of(int matchedCount, boolean bonusNumMatched) {
        return new WinningCondition(matchedCount, bonusNumMatched);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusNumMatched() {
        return bonusNumMatched;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningCondition)) return false;

        WinningCondition that = (WinningCondition) o;

        if (matchedCount != that.matchedCount) return false;
        return bonusNumMatched == that.bonusNumMatched;
    }

    @Override
    public int hashCode() {
        int result = matchedCount;
        result = 31 * result + (bonusNumMatched ? 1 : 0);
        return result;
    }
}
