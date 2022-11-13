package lotto.model;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RankCount {
    private final Map<Rank, Integer> rankCount;

    public RankCount(Map<Rank, Integer> rankCount) {
        this.rankCount = rankCount;
    }

    public BigDecimal benefit() {
        return BigDecimal.valueOf(rankCount.keySet().stream()
                .mapToDouble(rank -> rank.calculatePrice(rankCount.get(rank)))
                .sum());
    }

    public void findSecondRank(List<Lotto> lottos, LottoNumber bonusLotto) {
        rankCount.keySet().stream()
                .filter(rank -> isThreeRank(lottos, bonusLotto, rank))
                .map(rank -> rankCount.replace(Rank.THREE, rankCount.get(Rank.THREE) - 1))
                .map(rank -> rankCount.put(Rank.TWO, rankCount.getOrDefault(Rank.TWO, 0) + 1))
                .collect(Collectors.toSet());
    }

    public void putMatchingCount() {
        for (Rank rank : rankCount.keySet()) {
            rankCount.put(rank, (int) rankCount.keySet().stream()
                    .filter(countingMatch(rank))
                    .count());
        }
    }

    public Map<Rank, Integer> getRankCount() {
        return Collections.unmodifiableMap(rankCount);
    }

    private boolean isThreeRank(List<Lotto> lottos, LottoNumber bonusLotto, Rank rank) {
        return rank == Rank.THREE && isExistThree(lottos, bonusLotto);
    }

    private boolean isExistThree(List<Lotto> lottos, LottoNumber bonusLotto) {
        return lottos.stream()
                .anyMatch(lotto -> lotto.isSecondRank(bonusLotto));
        }

    private Predicate<Rank> countingMatch(Rank rank) {
        return rank::isMatchOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankCount that = (RankCount) o;
        return rankCount.equals(that.rankCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankCount);
    }
}
