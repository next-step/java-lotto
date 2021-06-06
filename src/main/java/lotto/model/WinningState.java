package lotto.model;

public class WinningState {
    private final int matchedCount;
    private final boolean bonusBallMatchSuccess;

    public WinningState(int matchedCount, boolean bonusBallMatchSuccess) {
        this.matchedCount = matchedCount;
        this.bonusBallMatchSuccess = bonusBallMatchSuccess;
    }

    public boolean isSpecificPrizeState(int specificPrizeCountCondition, boolean specificPrizeBonusBallCondition) {
        return matchedCount == specificPrizeCountCondition && bonusBallMatchSuccess == specificPrizeBonusBallCondition;
    }

    public int getMatchedCount() {
        return this.matchedCount;
    }

    public boolean isBonusBallMatchSuccess() {
        return this.bonusBallMatchSuccess;
    }
}
