package com.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LotteryCommission {

    private static final int DEFAULT_REVENUE = 0;
    private static final int LOTTERY_PRICE = 1_000;
    private static final int START_NUMBER = 1;
    private static final int TOTAL_NUMBER_COUNT = 45;
    private static final int NUMBER_COUNT = 6;
    private static final List<Integer> TOTAL_NUMBERS = IntStream.range(START_NUMBER, START_NUMBER + TOTAL_NUMBER_COUNT)
            .boxed()
            .collect(Collectors.toList());

    public List<Lottery> publishLotteries(Deposit deposit) {
        int lotteryCount = deposit.purchaseLottery();
        return IntStream.range(0, lotteryCount)
                .mapToObj(i -> publishLotteryAutomatically())
                .collect(Collectors.toList());
    }

    private Lottery publishLotteryAutomatically() {
        Collections.shuffle(TOTAL_NUMBERS);
        List<Integer> numbers = TOTAL_NUMBERS.stream()
                .limit(NUMBER_COUNT)
                .collect(Collectors.toList());
        return new Lottery(numbers);
    }

    public List<Statistic> calculateWinningStatistics(List<Lottery> lotteries, Lottery winningLottery) {
        return Stream.of(Rank.values()).map(rank -> {
            int lotteryCount = (int) lotteries.stream()
                    .filter(lottery -> rank.compareMatchingCount(lottery.compareMatchingNumbers(winningLottery)))
                    .count();
            return new Statistic(rank, lotteryCount);
        }).collect(Collectors.toList());
    }

    public float calculateYield(List<Lottery> lotteries, Lottery winningLottery) {
        List<Statistic> statistics = calculateWinningStatistics(lotteries, winningLottery);
        float revenue = statistics.stream()
                .map(Statistic::calculateTotalWinnings)
                .reduce(Integer::sum)
                .orElse(DEFAULT_REVENUE);
        return revenue / (LOTTERY_PRICE * lotteries.size());
    }
}
