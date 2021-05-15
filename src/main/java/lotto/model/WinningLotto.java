package lotto.model;

public class WinningLotto {
    final int matchedCount;
    final boolean bonusBall;

    public WinningLotto(int matchedCount, boolean bonusBall) {
        this.matchedCount = matchedCount;
        this.bonusBall = bonusBall;
    }

    public int getMatchedCount() {
        return this.matchedCount;
    }

    public boolean isBonusBall() {
        return this.bonusBall;
    }
}
