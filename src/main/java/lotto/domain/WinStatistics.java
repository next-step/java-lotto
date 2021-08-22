package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class WinStatistics {
    private final Map<Rank, Integer> winStatistics;

    private WinStatistics(Map<Rank, Integer> winStatistics) {
        this.winStatistics = winStatistics;
    }

    public static WinStatistics from(Map<Rank, Integer> winStatistics) {
        return new WinStatistics(winStatistics);
    }

    private long calculatePrizeMoney(Rank rank, int lottoCount) {
        Rank rankResult = Arrays.stream(Rank.values())
            .filter(e -> e == rank)
            .findFirst()
            .orElse(Rank.MISS);

        return rankResult.money()
            .multiply(lottoCount)
            .amount();
    }

    public float getRateOfReturn() {
        long prizeMoneySum = winStatistics
            .entrySet()
            .stream()
            .mapToLong(e -> calculatePrizeMoney(e.getKey(), e.getValue()))
            .sum();
        return (float) (Math.floor(prizeMoneySum / (winStatistics.size() * 10.0f)) / 100.0f);
    }

    public Map<Rank, Integer> result() {
        return Collections.unmodifiableMap(winStatistics);
    }
}
