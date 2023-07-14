package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Count> rankCount = new EnumMap<>(Rank.class);

    public LottoResult(final List<Rank> ranks) {
        ranks.forEach(this::increaseRankCount);
    }

    public Count countRank(final Rank rank) {
        return rankCount.getOrDefault(rank, new Count(0L));
    }

    public RateOfReturn calculateRateOfReturn(final Money spentMoney) {
        return Money.calculateRateOfReturn(calculateTotalPrize(), spentMoney);
    }

    private void increaseRankCount(final Rank rank) {
        rankCount.put(rank, countRank(rank).increaseByOne());
    }

    private Money calculateTotalPrize() {
        Money totalPrize = Money.createZero();

        for (final Rank rank : Rank.values()) {
            totalPrize = totalPrize.sum(calculatePrizePerRank(rank));
        }

        return totalPrize;
    }

    private Money calculatePrizePerRank(final Rank rank) {
        return rank.getPrize()
            .multiplyByCount(countRank(rank));
    }
}
