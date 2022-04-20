package lotto.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ranks {

    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = Collections.unmodifiableList(ranks);
    }

    public List<RankResult> groupBy() {
        Map<Rank, Long> rankGroupMap = initRankGroupingMap();
        for (Rank rank : ranks) {
            rankGroupMap.computeIfPresent(rank, (key, value) -> value + 1);
        }
        return getResults(rankGroupMap);
    }

    private Map<Rank, Long> initRankGroupingMap() {
        Map<Rank, Long> rankMap = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            if (rank.isMiss()) {
                continue;
            }
            rankMap.putIfAbsent(rank, 0L);
        }
        return rankMap;
    }

    private List<RankResult> getResults(Map<Rank, Long> rankGroupMap) {
        return rankGroupMap.entrySet().stream()
                .map(set -> new RankResult(set.getKey(), set.getValue()))
                .collect(Collectors.toList());
    }

}
