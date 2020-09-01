package com.lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LotteryCommission {

    private static final int DEFAULT_LOTTERY_COUNT = 0;

    public Lotteries publishLotteries(List<Lottery> manualLotteries, Deposit deposit) {
        IntStream.range(DEFAULT_LOTTERY_COUNT, deposit.getAutomaticLotteryCount())
                .mapToObj(i -> new Lottery(LotteryNumber.getLotteryNumbersAutomatically()))
                .forEach(manualLotteries::add);
        return new Lotteries(manualLotteries);
    }

    public Statistics calculateStatistics(Lotteries lotteries, WinningLottery winningLottery) {
        return Rank.calculateStatistics(lotteries.calculateRanks(winningLottery));
    }
}
