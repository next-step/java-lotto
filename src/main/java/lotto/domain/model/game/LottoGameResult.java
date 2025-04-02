package lotto.domain.model.game;

import lotto.domain.model.lotto.PurchaseAmount;

import java.util.*;

public class LottoGameResult {

    private final Map<Rank, Integer> rankCountMap = new HashMap<>();

    public void addResult(final Rank rank) {
        rankCountMap.merge(rank, 1, Integer::sum);
    }

    public Map<Rank, Integer> getRankCountMap() {
        return Collections.unmodifiableMap(rankCountMap);
    }

    public Prize getTotalPrize() {
        return Arrays.stream(Rank.values())
                .map(rank -> rank.getWinningPrize().multiply(rankCountMap.getOrDefault(rank, 0)))
                .reduce(Prize.zero(), Prize::add);
    }

    public Yield getYield(final PurchaseAmount purchaseAmount) {
        return new Yield(getTotalPrize(), purchaseAmount);
    }

}
