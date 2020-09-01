package com.lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {

    private static final int SCALE = 2;
    private static final int DEFAULT_LOTTERY_COUNT = 0;
    private static final BigDecimal LOTTERY_PRICE = new BigDecimal(1_000);
    private static final BigDecimal DEFAULT_REVENUE = BigDecimal.ZERO;
    private final List<Statistic> statistics;

    public Statistics(List<Statistic> statistics) {
        this.statistics = new ArrayList<>(statistics);
    }


    public String toStringFormatExceptLoser(String rankFormat, String rankBonusFormat, String lotteryCountFormat) {
        return this.statistics.stream()
                .filter(Statistic::hasWinnings)
                .map(statistic -> statistic.toString(rankFormat, rankBonusFormat, lotteryCountFormat))
                .collect(Collectors.joining("\n"));
    }

    public BigDecimal calculateYield() {
        int lotteryCount = calculateLotteryCount();
        if (lotteryCount == DEFAULT_LOTTERY_COUNT) {
            return DEFAULT_REVENUE;
        }
        BigDecimal revenue = this.statistics.stream()
                .map(Statistic::calculateTotalWinnings)
                .reduce(BigDecimal::add)
                .orElse(DEFAULT_REVENUE);
        return revenue.divide(LOTTERY_PRICE.multiply(new BigDecimal(lotteryCount)), SCALE, RoundingMode.HALF_EVEN);
    }

    private int calculateLotteryCount() {
        return this.statistics.stream()
                .mapToInt(Statistic::getLotteryCount)
                .reduce(Integer::sum)
                .orElse(DEFAULT_LOTTERY_COUNT);
    }
}
