package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Ranks {
    private final EnumMap<Rank, Integer> ranks;

    private Ranks() {
        this.ranks = new EnumMap<>(Rank.class);
        for(Rank rank : Rank.values()) {
            this.ranks.put(rank, 0);
        }
    }

    public Ranks(List<Rank> ranks) {
        this();
        for (Rank rank : ranks) {
            this.ranks.put(rank, countRank(rank));
        }
    }

    private Integer countRank(Rank rank) {
        if (this.ranks.containsKey(rank)) {
            return this.ranks.get(rank) + 1;
        }
        return 1;
    }

    public Double calculateRateOfReturn(Price price) {
        return price.divide(sumPrize());
    }

    private int sumPrize() {
        int sum = 0;
        for(Map.Entry<Rank, Integer> rank : ranks.entrySet()) {
            sum += rank.getKey().calculatePrize(rank.getValue());
        }
        return sum;
    }

    public EnumMap<Rank, Integer> getRanks() {
        return ranks;
    }
}
