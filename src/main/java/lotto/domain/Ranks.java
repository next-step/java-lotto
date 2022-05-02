package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ranks {

    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }
    public static Map<Rank, Integer> getGroupByMap(List<Integer> matchNumbers) {
        return new Ranks(matchNumbers.stream()
                .filter(r -> r >= 3)
                .map(Rank::getRank)
                .collect(Collectors.toList())).groupBy();
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public double getProfitRatio(BigDecimal totalPrize) {
        return 100d;
    }

    private Map<Rank, Integer> groupBy() {
        Map<Rank, Integer> resultRankMap = this.getResultRankMap();
        for (Rank rank : ranks) {
            resultRankMap.computeIfPresent(rank, (key, value) -> ++value);
        }
        return resultRankMap;
    }

    private Map<Rank, Integer> getResultRankMap() {
        Map<Rank, Integer> resultRankMap = new LinkedHashMap<>();
        Arrays.stream(Rank.values())
                .filter(r -> !r.equals(Rank.LOSE))
                .forEach(r -> resultRankMap.put(r, 0));
        return resultRankMap;
    }
}
