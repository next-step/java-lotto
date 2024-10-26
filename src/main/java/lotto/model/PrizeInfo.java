package lotto.model;

public class PrizeInfo {

    private int prize;
    private int winningCount;

    public PrizeInfo(int prize, int winningCount) {
        this.prize = prize;
        this.winningCount = winningCount;
    }

    public void increaseWinningCount() {
        this.winningCount++;
    }

    public int calculateTotalPrize() {
        return prize * winningCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getWinningCount() {
        return this.winningCount;
    }

}
