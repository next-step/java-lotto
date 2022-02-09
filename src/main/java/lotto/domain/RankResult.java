package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankResult {

    private final Map<Rank, Integer> rankResult;

    public RankResult(final Map<Rank, Integer> rankResult) {
        this.rankResult = new HashMap<>(rankResult);
    }

    public RankResult(final RankCount rankCount) {
        Map<Rank, Integer> rankResult = new HashMap<>(rankCount.rankCount());
        this.rankResult = rankResult;
    }

    public Map<Rank, Integer> getRankResult() {
        return rankResult;
    }

    public Money getTotalPrize(){
        return new Money(rankResult.entrySet().stream()
            .mapToInt(entry->entry.getKey().getPrize(entry.getValue()).getValue())
            .sum());
    }
}
