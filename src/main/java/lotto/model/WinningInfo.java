package lotto.model;

public class WinningInfo {
    private static final int[] MATCH_COUNT_BY_RANK = {0, 6, 5, 5, 4, 3};

    private int matchCount;
    private PrizeInfo prizeInfo;

    public WinningInfo(int rank, int prize, int winningCount) {
        this.matchCount = MATCH_COUNT_BY_RANK[rank];
        this.prizeInfo = new PrizeInfo(prize, winningCount);
    }

    public void increaseWinningCount() {
        prizeInfo.increaseWinningCount();
    }

    public int calculateTotalPrize() {
        return prizeInfo.calculateTotalPrize();
    }

    public int getPrize() {
        return prizeInfo.getPrize();
    }

    public int getWinningCount() {
        return prizeInfo.getWinningCount();
    }

    public int getMatchCount() {
        return this.matchCount;
    }

}
