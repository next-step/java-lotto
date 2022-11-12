package lotto.model;

import java.math.BigDecimal;
import java.util.*;

public class MatchingCollection {
    private final Map<Rank, Integer> matchCollection;

    public MatchingCollection(Map<Rank, Integer> matchCollection) {
        this.matchCollection = matchCollection;
    }

    public BigDecimal calculateBenefit() {
        return BigDecimal.valueOf(matchCollection.keySet().stream()
                .mapToDouble(rank -> rank.calculatePrice(matchCollection.get(rank)))
                .sum());
    }

    public Map<Rank, Integer> getMatchCollection() {
        return Collections.unmodifiableMap(matchCollection);
    }
}
