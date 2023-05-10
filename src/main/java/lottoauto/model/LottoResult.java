package lottoauto.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LottoResult {

    private final List<Integer> matchCount;
    private final int buyPrice;
    private final Map<Integer, Integer> matchFrequencyMap = new ConcurrentHashMap<>();
    private final double rate;

    public LottoResult(List<Integer> matchCount, int buyPrice) {
        this.matchCount = matchCount;
        this.rate = calculateRate();
        this.buyPrice = buyPrice;
    }

    public double calculateRate() {
        double summary = 0;
        for (Integer integer : matchCount) {
            int count = Collections.frequency(matchCount, integer);
            int reward = WinningReward.findRewardByMatches(integer).getReward();

            matchFrequencyMap.put(integer, count);

            summary += reward * count;
        }

        return Math.round(summary / buyPrice);

    }

    public List<Integer> getMatchCount() {
        return matchCount;
    }

    public Map<Integer, Integer> getMatchFrequency() {
        return this.matchFrequencyMap;
    }

    public double getRate() {
        return this.rate;
    }
}
