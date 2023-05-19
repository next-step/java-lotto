package lottoauto.model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {

    public static final int MINIMUM_MATCH_COUNT = 3;
    private final List<WinningReward> matchCount;
    private final LinkedHashMap<WinningReward, Integer> matchFrequencyMap;

    public LottoResult(List<WinningReward> matchCount) {
        this.matchCount = matchCount;
        this.matchFrequencyMap = Arrays.stream(WinningReward.values())
                .filter(x -> x.getMatchCount() >= MINIMUM_MATCH_COUNT)
                .collect(Collectors.toMap(e -> e, e -> 0, (a, b) -> a, LinkedHashMap::new));
        initFrequencyMap();
    }

    private void initFrequencyMap() {
        matchCount.stream()
                .filter(winningReward -> winningReward.getMatchCount() >= MINIMUM_MATCH_COUNT)
                .forEach(winningReward -> {
                    int count = Collections.frequency(matchCount, winningReward);
                    matchFrequencyMap.put(winningReward, count);
                });

    }

    public double getRate(int price) {
        double summary = 0;
        for (WinningReward reward : matchCount) {
            summary += reward.getReward() * matchFrequencyMap.getOrDefault(reward, 0);
        }

        return Math.round((summary / price) / 100);
    }

    public List<WinningReward> getMatchCount() {
        return matchCount;
    }

    public Map<WinningReward, Integer> getMatchFrequency() {
        return this.matchFrequencyMap;
    }

}
