package domain;


import java.math.BigDecimal;

public class WinningInfo {
    private final Rank rank;
    private int winningNumber;

    private WinningInfo(Rank rank, int winningNumber) {
        this.rank = rank;
        this.winningNumber = winningNumber;
    }

    public static WinningInfo of(Rank winningType) {
        return new WinningInfo(winningType, 0);
    }

    public BigDecimal getMultiplyWinningMoney() {
        BigDecimal winningNumber = new BigDecimal(this.winningNumber);
        return rank.getWinningMoney().multiply(winningNumber);
    }

    public void increaseHitNumber() {
        winningNumber++;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "WinningInfo{" +
                "winningType=" + rank +
                ", winningNumber=" + winningNumber +
                '}';
    }
}
