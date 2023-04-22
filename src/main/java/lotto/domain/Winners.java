package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Winners {
    public static final int DEFAULT_VALUE = 0;
    public static final int ADD_COUNT = 1;

    private final Map<Integer, Integer> winnersCount = new HashMap<>();

    public void addWinner(int matchingBall) {
        winnersCount.merge(matchingBall, ADD_COUNT, Integer::sum);
    }

    public int getWinnersCount(int matchingBall) {
        return winnersCount.getOrDefault(matchingBall, DEFAULT_VALUE);
    }

    public int getPrize(int matchingBall) {
        return Statistics.getPrize(matchingBall);
    }

    public double getProfit(Money amount) {
        int sum = winnersCount.keySet()
                .stream()
                .mapToInt(Statistics::getPrize)
                .reduce(DEFAULT_VALUE, Integer::sum);

        return (double) sum / amount.getAmount();
    }

}
