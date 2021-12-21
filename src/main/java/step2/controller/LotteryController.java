package step2.controller;

import step2.domain.Lotteries;
import step2.domain.Lottery;
import step2.domain.Number;
import step2.domain.Statistics;
import step2.strategy.AutoLotteryStrategy;
import step2.strategy.ManualLotteryStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryController {
    private static final int LOTTERY_PURCHASE_PRICE = 1_000;
    private static final String LOTTERY_SPLITTER = ",";

    public Statistics getStatistics(Lotteries lotteries, String winningNumbers, int bonusBallNumber) {
        return new Statistics(lotteries, getLottery(winningNumbers), Number.createFromInt(bonusBallNumber));
    }

    public Lotteries getLotteries(int purchaseAmount, String[] manualLotteryNumbers) {
        List<Lottery> lotteries = Arrays.stream(manualLotteryNumbers)
                .map(n -> Lottery.createFromStrategy(new ManualLotteryStrategy(n)))
                .collect(Collectors.toList());

        lotteries.addAll(IntStream.range(1, (purchaseAmount / LOTTERY_PURCHASE_PRICE) - manualLotteryNumbers.length)
                .mapToObj(i -> Lottery.createFromStrategy(new AutoLotteryStrategy()))
                .collect(Collectors.toList()));

        return Lotteries.createFromList(lotteries);
    }

    public double getProfitRate(Statistics statistics, int purchaseAmount) {
        return statistics.calculateProfitRate(purchaseAmount);
    }

    private Lottery getLottery(String numbers) {
        return Lottery.createFromList(Arrays.stream(numbers.split(LOTTERY_SPLITTER))
                .map(n -> Number.createFromString(n))
                .collect(Collectors.toList())
        );
    }
}
