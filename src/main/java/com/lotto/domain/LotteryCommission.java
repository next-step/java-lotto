package com.lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryCommission {

    private static final int SCALE = 2;
    private static final BigDecimal LOTTERY_PRICE = new BigDecimal(1_000);
    private static final BigDecimal DEFAULT_REVENUE = BigDecimal.ZERO;

    public List<Lottery> publishLotteries(Deposit deposit) {
        int lotteryCount = deposit.purchaseLottery();
        return IntStream.range(0, lotteryCount)
                .mapToObj(i -> publishLotteryAutomatically())
                .collect(Collectors.toList());
    }

    private Lottery publishLotteryAutomatically() {
        Set<LotteryNumber> lotteryNumbers = LotteryNumber.getLotteryNumbersAutomatically();
        return new Lottery(lotteryNumbers);
    }

    public List<Statistic> calculateWinningStatistics(List<Lottery> lotteries, WinningLottery winningLottery) {
        List<Rank> ranks = lotteries.stream()
                .map(winningLottery::matchRank)
                .collect(Collectors.toList());
        return Rank.makeStatistics(ranks);
    }

    public BigDecimal calculateYield(int lotteryCount, List<Statistic> statistics) {
        if (lotteryCount == 0) {
            return DEFAULT_REVENUE;
        }
        BigDecimal revenue = statistics.stream()
                .map(Statistic::calculateTotalWinnings)
                .reduce(BigDecimal::add)
                .orElse(DEFAULT_REVENUE);
        return revenue.divide(LOTTERY_PRICE.multiply(new BigDecimal(lotteryCount)), SCALE, RoundingMode.HALF_EVEN);
    }
}
