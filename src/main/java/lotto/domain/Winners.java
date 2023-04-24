package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Winners {
    private static final int DEFAULT_VALUE = 0;
    private static final int ADD_COUNT = 1;

    private final Map<Statistics, Integer> winnersCount = new EnumMap<>(Statistics.class);

    public void addWinner(int matchingBall) {
        winnersCount.merge(Statistics.initStatistics(matchingBall), ADD_COUNT, Integer::sum);
    }

    public int getWinnersCount(int matchingBall) {
        return winnersCount.getOrDefault(Statistics.initStatistics(matchingBall), DEFAULT_VALUE);
    }

    public int getPrize(int matchingBall) {
        return Statistics.initStatistics(matchingBall).getPrize();
    }

    public double getProfit(Money amount) {
        int sum = winnersCount.keySet()
                .stream()
                .mapToInt(statistics -> statistics.getPrize() * winnersCount.getOrDefault(statistics, DEFAULT_VALUE))
                .reduce(DEFAULT_VALUE, Integer::sum);

        return (double) sum / amount.getAmount();
    }

}
