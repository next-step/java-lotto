package step2.controller;

import step2.domain.Lotteries;
import step2.domain.Lottery;
import step2.domain.Statistics;

public class LotteryController {
    private static final int LOTTERY_PURCHASE_PRICE = 1000;
    private static final String LOTTERY_SPLITTER = ",";

    public Statistics getStatistics(Lotteries lotteries, String winningNumbers) {
        return new Statistics(lotteries, getWinningLottery(winningNumbers));
    }

    public Lotteries getLotteries(int purchaseAmount) {
        return new Lotteries(purchaseAmount / LOTTERY_PURCHASE_PRICE);
    }

    public double getProfitRate(Statistics statistics, int purchaseAmount) {
        return statistics.calculateProfitRate(purchaseAmount);
    }

    private Lottery getWinningLottery(String winningNumbers) {
        return Lottery.createFromArray(winningNumbers.split(LOTTERY_SPLITTER));
    }
}
