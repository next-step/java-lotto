package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Statistics {
    private static final long DEFAULT_VALUE = 0;

    private final Map<Prize, Long> statisticsWinnerMap;
    private final double profit;

    public Statistics(WinnerLotto winnerLotto, Lotto lotto, Money money) {
        this.statisticsWinnerMap = statisticsWinnerMap(winnerLotto, lotto);
        this.profit = calculateProfit(money);
    }

    private Map<Prize, Long> statisticsWinnerMap(WinnerLotto winnerLotto, Lotto lotto) {
        List<Prize> winnersList = winnerLotto.getPrizeList(lotto);
        return winnersList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public double provideProfit() {
        return profit;
    }

    public long getWinnersMatchingCount(Prize prize) {
        return statisticsWinnerMap.getOrDefault(prize, DEFAULT_VALUE);
    }

    private double calculateProfit(Money money) {
        long sum = getSumProfit();

        return (double) sum / money.getAmount();
    }

    private long getSumProfit() {
        return statisticsWinnerMap.entrySet()
                .stream()
                .mapToLong(prize -> {
                    Prize profitPrize = prize.getKey();
                    long matchingCount = prize.getValue();
                    return profitPrize.calculatePriceMoney(matchingCount);
                })
                .sum();
    }
}
