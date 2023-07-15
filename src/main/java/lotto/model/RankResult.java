package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class RankResult {
    private static final Integer DEFAULT_VALUE = 0;
    private final Map<Rank, Integer> rankResult;

    public RankResult(final WinningLotto winningLotto, final PurChasedLottos purChasedLottos) {
        rankResult = new HashMap<>();
        for (var purchasedLotto : purChasedLottos.getLottos()) {
            Rank rank = winningLotto.matchOfRank(purchasedLotto);
            rankResult.put(rank, getCountOfRank(rank) + 1);
        }
    }

    public Integer getCountOfRank(final Rank rank) {
        return rankResult.getOrDefault(rank, DEFAULT_VALUE);
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
