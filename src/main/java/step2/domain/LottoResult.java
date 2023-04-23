package step2.domain;

import java.util.Map;

public class LottoResult {

    private final Map<Integer, Integer> numberOfMatches;
    private final float rate;

    private LottoResult(Map<Integer, Integer> numberOfMatches, float rate) {
        this.numberOfMatches = numberOfMatches;
        this.rate = rate;
    }

    public static LottoResult makeResult(Map<Integer, Integer> numberOfMatches, float rate) {
        return new LottoResult(numberOfMatches, rate);
    }

    public Map<Integer, Integer> numberOfMatches() {
        return numberOfMatches;
    }

    public float rate() {
        return rate;
    }
}
