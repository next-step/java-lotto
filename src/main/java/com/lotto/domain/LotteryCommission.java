package com.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LotteryCommission {

    public static final int MATCHING_COUNT_INDEX = 0;
    public static final int WINNINGS_INDEX = 1;
    public static final int LOTTERY_COUNT_INDEX = 2;
    private static final int DEFAULT_REVENUE = 0;
    private static final int LOTTERY_PRICE = 1_000;
    private static final int START_NUMBER = 1;
    private static final int TOTAL_NUMBER_COUNT = 45;
    private static final int NUMBER_COUNT = 6;
    private static final List<Integer> TOTAL_NUMBERS = IntStream.range(START_NUMBER, START_NUMBER + TOTAL_NUMBER_COUNT)
            .boxed()
            .collect(Collectors.toList());

    private enum Ranking {
        FORTH(3, 5_000),
        THIRD(4, 50_000),
        SECOND(5, 1_500_000),
        FIRST(6, 2_000_000_000),
        ;

        final private int matchingCount;
        final private int winnings;

        Ranking(int matchingCount, int winnings) {
            this.matchingCount = matchingCount;
            this.winnings = winnings;
        }
    }

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

    public List<int[]> calculateWinningStatistics(List<Lottery> lotteries, Lottery winningLottery) {
        return Stream.of(Ranking.values()).map(ranking -> {
            int lotteryCount = (int) lotteries.stream()
                    .filter(lottery -> lottery.compareMatchingNumbers(winningLottery) == ranking.matchingCount)
                    .count();
            return new int[]{ranking.matchingCount, ranking.winnings, lotteryCount};
        }).collect(Collectors.toList());
    }

    public float calculateYield(List<Lottery> lotteries, Lottery winningLottery) {
        List<int[]> statistics = calculateWinningStatistics(lotteries, winningLottery);
        float revenue = statistics.stream()
                .map(statistic -> statistic[WINNINGS_INDEX] * statistic[LOTTERY_COUNT_INDEX])
                .reduce(Integer::sum)
                .orElse(DEFAULT_REVENUE);
        return revenue / (LOTTERY_PRICE * lotteries.size());
    }
}
