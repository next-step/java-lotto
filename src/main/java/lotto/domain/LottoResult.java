package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> matchCounts;
    private final double rate;

    public LottoResult(Map<Integer, Integer> matchCounts, double rate) {
        this.matchCounts = matchCounts;
        this.rate = rate;
    }

    public Map<Integer, Integer> getMatchCounts() {
        return matchCounts;
    }

    public double getRate() {
        return rate;
    }
}
