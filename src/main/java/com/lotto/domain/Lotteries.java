package com.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotteries {

    private final List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = new ArrayList<>(lotteries);
    }

    public List<Rank> calculateRanks(WinningLottery winningLottery) {
        return this.lotteries.stream()
                .map(winningLottery::matchRank)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.lotteries.stream()
                .map(Lottery::toString)
                .collect(Collectors.joining("\n"));
    }
}
