package lotto;

import java.util.HashMap;

public class MyRank {
    private HashMap<Rank, Integer> rankMap;

    public MyRank() {
        initializeRankMap();
    }

    public void add(Rank rank) {
        rankMap.put(rank, rankMap.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return rankMap.get(rank);
    }

    private void initializeRankMap() {
        rankMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankMap.put(rank, 0);
        }
    }
}