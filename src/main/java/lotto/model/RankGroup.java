package lotto.model;

import java.math.BigDecimal;
import java.util.*;

public class RankGroup {
    private final Map<Rank, Integer> rankCount;

    public RankGroup(Map<Rank, Integer> rankCount) {
        this.rankCount = rankCount;
    }

    public BigDecimal benefit() {
        return BigDecimal.valueOf(rankCount.keySet().stream()
                .mapToDouble(rank -> rank.calculatePrice(rankCount.get(rank)))
                .sum());
    }

    public void putMatchingCount() {
        for (Rank rank : rankCount.keySet()) {
            rankCount.put(rank, (int) rankCount.keySet().stream()
                    .filter(rank::isMatchOrder)
                    .count());
        }
    }

    public Map<Rank, Integer> getRankCount() {
        return Collections.unmodifiableMap(rankCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankGroup that = (RankGroup) o;
        return rankCount.equals(that.rankCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankCount);
    }
}
