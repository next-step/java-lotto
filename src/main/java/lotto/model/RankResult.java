package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class RankResult {
    private static final Integer DEFAULT_VALUE = 0;
    private final Map<Rank, Integer> rankResult;

    public RankResult() {
        this.rankResult = new HashMap<>();
    }

    public Integer getCountOfRank(final Rank rank) {
        if (rankResult.containsKey(rank)) {
            return rankResult.get(rank);
        }
        return DEFAULT_VALUE;
    }

    public void plusCountOfRank(final Rank rank) {
        rankResult.put(rank, getCountOfRank(rank) + 1);
    }

    public int getTotalRankReward() {
        return rankResult.keySet()
                .stream()
                .mapToInt(getRankReward())
                .sum();
    }

    private ToIntFunction<Rank> getRankReward() {
        return rank -> rank.getReward() * getCountOfRank(rank);
    }

}
