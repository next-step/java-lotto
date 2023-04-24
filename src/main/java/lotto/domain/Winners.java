package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Winners {
    private static final int DEFAULT_VALUE = 0;
    private static final int ADD_COUNT = 1;

    private final Map<Statistics, Integer> winnersCount = new EnumMap<>(Statistics.class);

    public void addWinner(int matchingBall, boolean hasBonusNumber) {
        winnersCount.merge(Statistics.initStatistics(matchingBall, hasBonusNumber), ADD_COUNT, Integer::sum);
    }

    public int getWinnersMatchingCount(Statistics statistics) {
        return winnersCount.getOrDefault(statistics, DEFAULT_VALUE);
    }

    public int getPrize(int matchingBall, boolean hasBonusNumber) {
        return Statistics.initStatistics(matchingBall, hasBonusNumber).getPrize();
    }

    public double getProfit(Money amount) {
        int sum = winnersCount.keySet()
                .stream()
                .mapToInt(statistics -> statistics.getTotalPrize(winnersCount.getOrDefault(statistics, DEFAULT_VALUE)))
                .reduce(DEFAULT_VALUE, Integer::sum);

        return (double) sum / amount.getAmount();
    }

}
