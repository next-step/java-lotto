package lotto.domain;

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

    public static List<RankResult> getRankResults(List<Rank> ranks) {
        return new Ranks(ranks).groupBy();
    }

    private List<RankResult> groupBy() {
        Map<Rank, Integer> resultRankMap = this.initResultMap();
        for (Rank rank : ranks) {
            resultRankMap.computeIfPresent(rank, (key, value) -> ++value);
        }
        return this.getRankResults(resultRankMap);
    }

    private Map<Rank, Integer> initResultMap() {
        Map<Rank, Integer> resultRankMap = new LinkedHashMap<>();
        Arrays.stream(Rank.values())
                .filter(r -> !r.equals(Rank.LOSE))
                .forEach(r -> resultRankMap.put(r, 0));
        return resultRankMap;
    }

    private List<RankResult> getRankResults(Map<Rank, Integer> resultRankMap) {
        return resultRankMap.entrySet().stream()
                .map((e) -> new RankResult(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }
}
