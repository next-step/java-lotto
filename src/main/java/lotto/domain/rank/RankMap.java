package lotto.domain.rank;

import lotto.domain.Amount;
import lotto.domain.money.ImmutableMoney;
import lotto.domain.money.Money;

import java.util.*;

public class RankMap {

    private final Map<Rank, Amount> rankMap = new HashMap<>();

    public RankMap(Rank[] values) {
        for (Rank rank : Rank.values()) {
            rankMap.put(rank, new Amount());
        }
        for (Rank rank : values) {
            rankMap.put(rank, rankMap.get(rank).plusOne());
        }
    }

    public ImmutableMoney reward() {
        Money totalReward = new Money(0);
        for (Rank rank : rankMap.keySet()) {
            Money reward = rank.reward().money();
            reward.multiply(rankMap.get(rank).amount());
            totalReward.add(reward);
        }
        return totalReward;
    }

    public Amount amount(Rank rank) {
        return rankMap.get(rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankMap rankMap1 = (RankMap) o;
        return Objects.equals(rankMap, rankMap1.rankMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankMap);
    }
}
