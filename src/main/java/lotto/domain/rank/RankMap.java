package lotto.domain.rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RankMap {

    private final Map<Rank, Integer> rankMap = new HashMap<>();
    private final int RANK_COUNT_DEFAULT = 0;

    public RankMap() {
        this(Rank.values());
    }

    public RankMap(Rank[] values) {
        for (Rank rank : values) {
            rankMap.put(rank, RANK_COUNT_DEFAULT);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankMap rankMap1 = (RankMap) o;
        return RANK_COUNT_DEFAULT == rankMap1.RANK_COUNT_DEFAULT && Objects.equals(rankMap, rankMap1.rankMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankMap, RANK_COUNT_DEFAULT);
    }
}
