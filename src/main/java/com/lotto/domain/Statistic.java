package com.lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class Statistic {

    private final Rank rank;
    private final int lotteryCount;

    public Statistic(Rank rank, List<Rank> ranks) {
        this.rank = rank;
        this.lotteryCount = (int) ranks.stream()
                .filter(item -> this.rank == item)
                .count();
    }

    public BigDecimal calculateTotalWinnings() {
        return rank.calculateTotalWinnings(lotteryCount);
    }

    public String toString(String rankFormat, String rankBonusFormat, String lotteryCountFormat) {
        return rank.toString(rankFormat, rankBonusFormat) + String.format(lotteryCountFormat, lotteryCount);
    }
}
