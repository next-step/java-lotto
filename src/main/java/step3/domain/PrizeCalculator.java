package step3.domain;

public class PrizeCalculator {

    private final WinningType winningType;
    private int winnerCount;

    public PrizeCalculator(int matchCount) {
        this.winningType = WinningType.ofMatchCount(matchCount);
        this.winnerCount = 0;
    }

    public void addCount() {
        winnerCount++;
    }

    public long getResult() {
        return winnerCount * winningType.getPrize();
    }
}
