package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private static final int DEFAULT_VALUE = 0;
    private static final int ADD_COUNT = 1;

    private static final Map<Prize, Integer> statisticsWinnerMap = new EnumMap<>(Prize.class);

    public static Statistics doStatistic(WinnerLotto winnerLotto, Lotto lotto) {
        List<Winners> winnersList = winnerLotto.findWinnerList(lotto);
        winnersList.forEach(winners -> {
            Prize prize = winners.providePrize();
            statisticsWinnerMap.merge(prize, ADD_COUNT, Integer::sum);
        });

        return new Statistics();
    }

    public double getProfit(Money money) {

        int sum = getSumProfit();

        return (double) sum / money.getAmount();
    }

    public static int getWinnersMatchingCount(Prize prize) {
        return statisticsWinnerMap.getOrDefault(prize, DEFAULT_VALUE);
    }

    private int getSumProfit() {
        return statisticsWinnerMap.entrySet()
                .stream()
                .mapToInt(prize -> {
                    Prize profitPrize = prize.getKey();
                    int matchingCount = prize.getValue();
                    return profitPrize.calculatePriceMoney(matchingCount);
                })
                .sum();
    }
}
