package com.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotteries {

    private static final int DEFAULT_LOTTERY_COUNT = 0;
    private final List<Lottery> lotteries;

    public Lotteries() {
        this.lotteries = new ArrayList<>();
    }

    public void addLottery(Lottery lottery) {
        this.lotteries.add(lottery);
    }

    public void publishLotteryAutomatically(int lotteryCount) {
        IntStream.range(DEFAULT_LOTTERY_COUNT, lotteryCount)
                .mapToObj(i -> new Lottery(LotteryNumber.getLotteryNumbersAutomatically()))
                .forEach(this.lotteries::add);
    }

    public Statistics calculateStatistics(WinningLottery winningLottery) {
        List<Rank> ranks = this.lotteries.stream()
                .map(winningLottery::matchRank)
                .collect(Collectors.toList());
        return Rank.calculateStatistics(ranks);
    }

    @Override
    public String toString() {
        return this.lotteries.stream()
                .map(Lottery::toString)
                .collect(Collectors.joining("\n"));
    }
}
