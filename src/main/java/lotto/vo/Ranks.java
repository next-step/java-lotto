package lotto.vo;

import java.util.Map;

public class Ranks {
    private Map<Rank, Integer> rankMappers;

    Ranks(Map<Rank, Integer> rankMappers) {
        this.rankMappers = rankMappers;
    }

    public int rankPerWinningCount(Rank rankType) {
        return rankMappers.get(rankType);
    }
}
