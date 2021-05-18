package lotto.model;

public class WinningState {
    final int matchedCount;
    final boolean matchingBonusBall;

    public WinningState(int matchedCount, boolean bonusBall) {
        this.matchedCount = matchedCount;
        this.matchingBonusBall = bonusBall;
    }

    public boolean getBonusBallState() {
        return this.matchingBonusBall;
    }

    public int getMatchedCount() {
        return this.matchedCount;
    }
}
