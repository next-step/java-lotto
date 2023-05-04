package lotto.step3.domain;

import lotto.step3.enums.MatchNumber;

import java.util.Map;

public class Result {
    private Map<MatchNumber, Integer> stat;

    private static final double PERCENTAGE = 100.0;

    public Result(Map<MatchNumber, Integer> stat) {
        this.stat = stat;
    }

    public Map<MatchNumber, Integer> getStat() {
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
                .mapToInt(m -> m.getMatchPrize() * stat.get(m))
                .sum();
    }
}
