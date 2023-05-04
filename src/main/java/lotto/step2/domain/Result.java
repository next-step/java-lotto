package lotto.step2.domain;

import lotto.step2.enums.MatchNumber;

import java.util.Map;

public class Result {
    private Map<MatchNumber, Long> stat;

    private static final double PERCENTAGE = 100.0;

    public Result(Map<MatchNumber, Long> stat) {
        this.stat = stat;
    }

    public Map<MatchNumber, Long> getStat() {
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
                .mapToLong(m -> m.getMatchPrize() * stat.get(m))
                .sum();
    }
}
