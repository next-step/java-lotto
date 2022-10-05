package lotto.domain;

public class WinningGrade {

    private final int matchingCount;
    private int count;
    private int winningPrice;

    public WinningGrade(int matchingCount, int winningPrice) {
        this(matchingCount, 0, winningPrice);
    }

    public WinningGrade(int matchingCount, int count, int winningPrice) {
        this.matchingCount = matchingCount;
        this.count = count;
        this.winningPrice = winningPrice;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int getCount() {
        return this.count;
    }

    public int totalWinningPrice() {
        return this.count * this.winningPrice;
    }

    public void increaseCount() {
        this.count += 1;
    }
}
