package lotto.domain.model.game;

import java.util.*;

public class LottoGameResult {

    private final Map<Rank, Integer> rankCountMap = new HashMap<>();

    public void addResult(final Rank rank) {
        rankCountMap.merge(rank, 1, Integer::sum);
    }

    public Map<Rank, Integer> getRankCountMap() {
        return Collections.unmodifiableMap(rankCountMap);
    }

    public int getTotalPrize() {
        return Arrays.stream(Rank.values())
                .map(rank -> rankCountMap.getOrDefault(rank, 0) * rank.getWinningPrize())
                .reduce(0, Integer::sum);
    }

    public double getYield(final int purchaseAmount) {
        return (double) getTotalPrize() / purchaseAmount;
    }

}
