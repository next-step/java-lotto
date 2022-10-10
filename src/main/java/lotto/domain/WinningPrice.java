package lotto.domain;

public enum WinningPrice {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000)
    ;

    private final int matchingCount;
    private final int winningPrice;

    WinningPrice(int matchingCount, int winningPrice) {
        this.matchingCount = matchingCount;
        this.winningPrice = winningPrice;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
