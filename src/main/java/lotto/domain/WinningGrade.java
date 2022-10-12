package lotto.domain;

public class WinningGrade {

    private int count;
    private WinningPrice winningPrice;

    public WinningGrade(WinningPrice winningPrice) {
        this(winningPrice, 0);
    }

    public WinningGrade(WinningPrice winningPrice, int count) {
        this.winningPrice = winningPrice;
        this.count = count;
    }

    public int getMatchingCount() {
        return this.winningPrice.getMatchingCount();
    }

    public int getWinningPrice() {
        return this.winningPrice.getWinningPrice();
    }

    public int getCount() {
        return this.count;
    }

    public int totalWinningPrice() {
        return this.count * this.winningPrice.getWinningPrice();
    }

    public void increaseCount() {
        this.count += 1;
    }

    @Override
    public String toString() {
        return "WinningGrade{" +
                "count=" + count +
                ", winningPrice=" + winningPrice +
                '}';
    }
}
