package lotto.domain;

import java.util.Map;

public class Reward {
    public static final Map<Integer, Long> PRIZES = Map.of(
            3, 5_000L,
            4, 50_000L,
            5, 1_500_000L,
            6, 2_000_000_000L
    );

    private final int matchCount;

    public Reward(int matchCount) {
        this.matchCount = matchCount;
    }

    public Long calculatePrize() {
        return PRIZES.getOrDefault(this.matchCount, 0L);
    }

    public void applyMatchCount(Map<Integer, Integer> matchMap) {
        matchMap.put(this.matchCount, matchMap.getOrDefault(this.matchCount, 0) + 1);
    }
}
