package com.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotteries {

    private final List<Lottery> lotteries;

    public Lotteries() {
        this.lotteries = new ArrayList<>();
    }

    public void publishLotteryAutomatically(int lotteryCount) {
        IntStream.range(0, lotteryCount)
                .mapToObj(i -> new Lottery(LotteryNumber.getLotteryNumbersAutomatically()))
                .forEach(this.lotteries::add);
    }

    public int size() {
        return this.lotteries.size();
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
