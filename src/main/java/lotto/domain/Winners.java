package lotto.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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
                .reduce(0, Integer::sum);

        DecimalFormat form = new DecimalFormat("#.##");
        form.setRoundingMode(RoundingMode.DOWN);

        return Double.parseDouble(form.format((double) sum / amount.getAmount()));
    }

}
