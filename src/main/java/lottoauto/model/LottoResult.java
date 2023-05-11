package lottoauto.model;

import java.util.*;
import java.util.stream.Collectors;
import lottoauto.model.Constant.LottoMatch;

public class LottoResult {

    private final List<WinningReward> matchCount;
    private final int buyPrice;
    private final LinkedHashMap<WinningReward, Integer> matchFrequencyMap = Arrays.stream(WinningReward.values())
            .filter(x -> x.getMatch() >= LottoMatch.MINIMUM_MATCH_COUNT)
            .collect(Collectors.toMap(e -> e, e -> 0, (a, b) -> a, LinkedHashMap::new));
    private final double rate;

    public LottoResult(List<WinningReward> matchCount, int buyPrice) {
        this.matchCount = matchCount;
        this.buyPrice = buyPrice;
        this.rate = calculateRate();
    }

    public double calculateRate() {
        double summary = 0;
        for (WinningReward reward : matchCount) {
            int count = Collections.frequency(matchCount, reward);
            matchFrequencyMap.put(reward, count);
            summary += reward.getReward() * count;
        }

        return Math.round(summary / buyPrice);

    }

    public List<WinningReward> getMatchCount() {
        return matchCount;
    }

    public Map<WinningReward, Integer> getMatchFrequency() {
        return this.matchFrequencyMap;
    }

    public double getRate() {
        return this.rate;
    }
}
