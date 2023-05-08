package lotto.step4.domain;

import lotto.step4.enums.Rank;

import java.util.Map;

public class Result {
    private Map<Rank, Long> stat;

    private static final double PERCENTAGE = 100.0;

    public Result(Map<Rank, Long> stat) {
        this.stat = stat;
    }

    public Map<Rank, Long> getStat() {
        return stat;
    }

    public double profit(int cost) {
        return map((double) sum() / cost);
    }

    private double map(double origin) {
        return Math.floor(origin * PERCENTAGE) / PERCENTAGE;
    }

    private long sum() {
        return stat.keySet().stream()
                .mapToLong(m -> m.getPrize() * stat.get(m))
                .sum();
    }
}
