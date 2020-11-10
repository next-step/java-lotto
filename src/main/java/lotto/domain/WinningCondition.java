package lotto.domain;

class WinningCondition {
    private final int matchedCount;
    private final boolean bonusNumMatched;

    private WinningCondition(int matchedCount, boolean bonusNumMatched) {
        this.matchedCount = matchedCount;
        this.bonusNumMatched = bonusNumMatched;
    }

    public static WinningCondition of(int matchedCount, boolean bonusNumMatched) {
        return new WinningCondition(matchedCount, bonusNumMatched);
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
