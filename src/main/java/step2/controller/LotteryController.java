package step2.controller;

import step2.domain.Lotteries;
import step2.domain.Lottery;
import step2.domain.enums.RANKING;
import step2.domain.Number;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LotteryController {
    public Map<RANKING, Integer> process(Lotteries lotteries, String winningNumbers) {
        Lottery lottery = getLottery(winningNumbers);
        return lotteries.getStaticResult(lottery);
    }

    public Lotteries getLotteries(int purchaseCount) {
        return new Lotteries(purchaseCount);
    }

    public Lottery getLottery(String winningNumbers) {
        List<Number> numbers = Arrays.stream(winningNumbers.split(", "))
                .map(n -> Number.createFromString(n))
                .collect(Collectors.toList());

        return new Lottery(numbers);
    }

    public double calculateProfitRate(double i, double i1) {
        return Math.floor(i1 / i * 100) / 100;
    }

    public int calculateProfitAmount(Map<RANKING, Integer> statisticResult) {
        int money = 0;

        for (Map.Entry<RANKING, Integer> entry : statisticResult.entrySet()) {
            money += entry.getKey().getPrizeMoney() * entry.getValue();
        }

        return money;
    }
}
