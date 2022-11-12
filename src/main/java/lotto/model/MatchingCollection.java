package lotto.model;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MatchingCollection {
    private final Map<Rank, Integer> matchCollection;

    public MatchingCollection() {
        this(new EnumMap<>(Rank.class));
    }

    public MatchingCollection(Map<Rank, Integer> matchCollection) {
        this.matchCollection = matchCollection;
    }

    public BigDecimal calculateBenefit() {
        return BigDecimal.valueOf(matchCollection.keySet().stream()
                .mapToDouble(rank -> rank.calculatePrice(matchCollection.get(rank)))
                .sum());
    }

    public void findSecondRank(List<Lotto> lottos, LottoNumber bonusLotto) {
        matchCollection.keySet().stream()
                .filter(rank -> isThreeRank(lottos, bonusLotto, rank))
                .map(rank -> matchCollection.replace(Rank.THREE, matchCollection.get(Rank.THREE) - 1))
                .map(rank -> matchCollection.put(Rank.TWO, matchCollection.getOrDefault(Rank.TWO, 0) + 1))
                .collect(Collectors.toSet());
    }

    public void putMatchingCount(List<Rank> ranks) {
        for (Rank rank : ranks) {
            matchCollection.put(rank, (int) ranks.stream()
                    .filter(countingMatch(rank))
                    .count());
        }
    }

    public Map<Rank, Integer> getMatchCollection() {
        return Collections.unmodifiableMap(matchCollection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchingCollection that = (MatchingCollection) o;
        return matchCollection.equals(that.matchCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCollection);
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
}
