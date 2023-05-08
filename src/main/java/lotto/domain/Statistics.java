package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Statistics {
    private static final long DEFAULT_VALUE = 0;

    private final Map<Prize, Long> statisticsWinnerMap;

    public Statistics(WinnerLotto winnerLotto, Lotto lotto) {
        this.statisticsWinnerMap = statisticsWinnerMap(winnerLotto, lotto);
    }

    private Map<Prize, Long> statisticsWinnerMap(WinnerLotto winnerLotto, Lotto lotto) {
        List<Winners> winnersList = winnerLotto.findWinnerList(lotto);

       return winnersList.stream()
                .collect(Collectors.groupingBy(Winners::providePrize, Collectors.counting()));
     }

    public double getProfit(Money money) {

        long sum = getSumProfit();

        return (double) sum / money.getAmount();
    }

    public long getWinnersMatchingCount(Prize prize) {
        return statisticsWinnerMap.getOrDefault(prize, DEFAULT_VALUE);
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
