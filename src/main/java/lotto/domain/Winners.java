package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Winners {
    private static final int DEFAULT_VALUE = 0;
    private static final int ADD_COUNT = 1;

    private Map<Statistics, Integer> winnersCount = new EnumMap<>(Statistics.class);

    public Winners(Map<Statistics, Integer> winnersCount) {
        this.winnersCount = winnersCount;
    }

    public Winners() {
    }

    public void addWinner(Statistics statistics) {
        winnersCount.merge(statistics, ADD_COUNT, Integer::sum);
    }

    public int getWinnersMatchingCount(Statistics statistics) {
        return winnersCount.getOrDefault(statistics, DEFAULT_VALUE);
    }

    public double getProfit(Money amount) {
        int sum = winnersCount.keySet()
                .stream()
                .mapToInt(statistics -> statistics.getTotalPrize(winnersCount.getOrDefault(statistics, DEFAULT_VALUE)))
                .reduce(DEFAULT_VALUE, Integer::sum);

        return (double) sum / amount.getPrice();
    }

    @Override
    public String toString() {
        return "" + winnersCount;
    }
}
