package domain;

import java.util.*;

public class LottoResult {
    private static Map<Rank, Integer> resultMap = new HashMap<>();

    public LottoResult() {
        for(Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public static Integer getCount(Rank rank) {
        return resultMap.get(rank);
    }

    public static Map<Rank, Integer> getResultMap() {
        return resultMap;
    }

    public static void addLotto(Rank rank) {
        resultMap.put(rank, resultMap.get(rank) + 1);
    }

    public static Set<Map.Entry<Rank, Integer>> entrySet() {
        return resultMap.entrySet();
    }
}
