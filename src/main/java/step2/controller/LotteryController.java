package step2.controller;

import step2.domain.Lotteries;
import step2.domain.Lottery;
import step2.domain.Number;
import step2.domain.Statistics;
import step2.strategy.AutoLotteryStrategy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LotteryController {
    private static final int LOTTERY_PURCHASE_PRICE = 1000;
    private static final String LOTTERY_SPLITTER = ",";

    public Statistics getStatistics(Lotteries lotteries, String winningNumbers) {
        return new Statistics(lotteries, getWinningNumbers(winningNumbers));
    }

    public Lotteries getLotteries(int purchaseAmount) {
        return Lotteries.createFromCount(new AutoLotteryStrategy(), purchaseAmount / LOTTERY_PURCHASE_PRICE);
    }

    public double getProfitRate(Statistics statistics, int purchaseAmount) {
        return statistics.calculateProfitRate(purchaseAmount);
    }

    private Lottery getWinningNumbers(String winningNumbers) {
        return Lottery.createFromList(Arrays.stream(winningNumbers.split(LOTTERY_SPLITTER))
                .map(n -> Number.createFromString(n))
                .collect(Collectors.toList())
        );
    }
}
