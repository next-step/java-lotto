package lotto.model;

public class WinningState {
    private final int matchedCount;
    private final boolean bonusBallMatchSuccess;

    public WinningState(int matchedCount, boolean bonusBallMatchSuccess) {
        this.matchedCount = matchedCount;
        this.bonusBallMatchSuccess = bonusBallMatchSuccess;
    }

    public boolean isSecondPrizeState(int secondPrizeCountCondition, boolean secondPrizeBonusBallCondition) {
        return matchedCount == secondPrizeCountCondition && bonusBallMatchSuccess == secondPrizeBonusBallCondition;
    }

    public int getMatchedCount() {
        return this.matchedCount;
    }

    public boolean isBonusBallMatchSuccess() {
        return this.bonusBallMatchSuccess;
    }
}
