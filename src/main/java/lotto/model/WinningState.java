package lotto.model;

public class WinningState {
    private final int matchedCount;
    private final boolean bonusBallMatchSuccess;

    public WinningState(int matchedCount, boolean bonusBallMatchSuccess) {
        this.matchedCount = matchedCount;
        this.bonusBallMatchSuccess = bonusBallMatchSuccess;
    }

    public boolean isBonusBallMatchSuccess() {
        return this.bonusBallMatchSuccess;
    }

    public int getMatchedCount() {
        return this.matchedCount;
    }
}
