package com.lotto.domain;

public class LotteryCommission {

    public Lotteries publishLotteries(Deposit deposit) {
        int lotteryCount = deposit.purchaseLottery();
        Lotteries lotteries = new Lotteries();
        lotteries.publishLotteryAutomatically(lotteryCount);
        return lotteries;
    }

    public Statistics calculateStatistics(Lotteries lotteries, WinningLottery winningLottery) {
        return lotteries.calculateStatistics(winningLottery);
    }
}
