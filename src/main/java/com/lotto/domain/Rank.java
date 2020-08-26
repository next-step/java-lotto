package com.lotto.domain;

public enum Rank {
    FORTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ;

    final private int matchingCount;
    final private int winnings;

    Rank(int matchingCount, int winnings) {
        this.matchingCount = matchingCount;
        this.winnings = winnings;
    }

    public boolean compareMatchingCount(int matchingCount) {
        return this.matchingCount == matchingCount;
    }

    public int calculateTotalWinnings(int lotteryCount) {
        return winnings * lotteryCount;
    }

    @Override
    public String toString() {
        return String.format("%2d 개 일치 (%10d 원)", matchingCount, winnings);
    }
}
