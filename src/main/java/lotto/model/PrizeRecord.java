package lotto.model;

public class PrizeRecord {

    private int prize;
    private int winningCount;

    public PrizeRecord(int prize, int winningCount) {
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