package com.lotto.domain;

public class Statistic {

    private final Rank rank;
    private final int lotteryCount;

    public Statistic(Rank rank, int lotteryCount) {
        this.rank = rank;
        this.lotteryCount = lotteryCount;
    }

    public int calculateTotalWinnings() {
        return rank.calculateTotalWinnings(lotteryCount);
    }

    @Override
    public String toString() {
        return String.format("%s - %2d 개", rank, lotteryCount);
    }
}
