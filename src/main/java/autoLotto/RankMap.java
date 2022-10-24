package autoLotto;

import java.util.HashMap;
import java.util.Map;

import static autoLotto.Rank.*;

public class RankMap {
    private static final Map<Rank, Integer> rankMap = new HashMap<>();

    static {
        rankMap.put(FIRST, 0);
        rankMap.put(SECOND, 0);
        rankMap.put(THIRD, 0);
        rankMap.put(FOURTH, 0);
        rankMap.put(FIFTH, 0);
        rankMap.put(MISS, 0);
    }

    public static void count(Rank rank) {
        rankMap.put(rank, rankMap.get(rank) + 1);
    }

    public static Map<Rank, Integer> getRankMap() {
        return rankMap;
    }
}
