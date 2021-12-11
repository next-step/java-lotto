package lotto.domain;

public enum Rank {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int matchedCount;
    private final int winningAmount;

    private Rank(int matchedCount, int winningAmount) {
        this.matchedCount = matchedCount;
        this.winningAmount = winningAmount;
    }

    public int matchedCount() {
        return matchedCount;
    }

    public int winningCount() {
        return winningAmount;
    }

}