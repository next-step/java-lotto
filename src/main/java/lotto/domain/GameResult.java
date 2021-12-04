package lotto.domain;

import java.util.Map;

public class GameResult {

    private final Map<Award, Long> results;
    private final double yield;

    private GameResult(Map<Award, Long> results, int startMoney) {
        this.results = results;
        this.yield = calculateYield(sumOfAward(), startMoney);
    }

    public static GameResult create(Map<Award, Long> results, int startMoney) {
        return new GameResult(results, startMoney);
    }


    public long getResultByCount(Award award) {
        return results.getOrDefault(award, 0L);
    }

    public double getYield() {
        return yield;
    }

    private long sumOfAward() {
        return results.keySet().stream()
            .mapToLong(this::sumWinningPriceByAward)
            .sum();
    }

    private long sumWinningPriceByAward(Award award) {
        return results.get(award) * award.getReward();
    }

    private double calculateYield(long sum, int startMoney) {
        if (sum == 0) {
            return 0L;
        }

        return sum / (double) startMoney;
    }
}
