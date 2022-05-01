package lotto.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Ranks {

    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public double getProfitRatio(BigDecimal totalPrize) {
        return 100d;
    }

    public Map<Rank, Integer> groupBy() {
        Map<Rank, Integer> resultRankMap = Rank.getResultRankMap();
        for (Rank rank : ranks) {
            resultRankMap.computeIfPresent(rank, (key, value) -> ++value);
        }
        return resultRankMap;
    }
}
