package lotto.vo;

import lotto.utils.Const;

import java.util.HashMap;
import java.util.Map;

public class Ranks {
    private Map<Rank, Integer> rankMappers;

    Ranks(Map<Rank, Integer> rankMappers) {
        this.rankMappers = rankMappers;
    }

    public static Map<Rank, Integer> getRankIntegerMap() {
        Map<Rank, Integer> rankMappers = new HashMap<>();
        rankMappers.put(Rank.FIRST_PLACE, Const.INITIAL_NUMBER);
        rankMappers.put(Rank.SECOND_PLACE, Const.INITIAL_NUMBER);
        rankMappers.put(Rank.THIRD_PLACE, Const.INITIAL_NUMBER);
        rankMappers.put(Rank.FOURTH_PLACE, Const.INITIAL_NUMBER);
        rankMappers.put(Rank.FAILURE, Const.INITIAL_NUMBER);
        return rankMappers;
    }

    public int rankPerWinningCount(Rank rankType) {
        return rankMappers.get(rankType);
    }
}
