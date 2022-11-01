package lotto;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyRank {
    private Map<Rank, Integer> rankMap;

    public MyRank() {
        initializeRankMap();
    }

    public double profit(double paidAmount) {
        double sum = 0.0;
        for (Rank rank : rankMap.keySet()) {
            sum += rank.getPrize() * rankMap.get(rank);
        }

        return sum / paidAmount;
    }

    public Map<Rank, Integer> getRankMap() {
        return rankMap;
    }

    public void add(Rank rank) {
        rankMap.put(rank, rankMap.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return rankMap.get(rank);
    }

    public List<Rank> all() {
        return rankMap.keySet()
                .stream()
                .filter(Rank::isNotNone)
                .sorted(Comparator.comparing(Rank::ordinal))
                .collect(Collectors.toList());
    }

    private void initializeRankMap() {
        rankMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankMap.put(rank, 0);
        }
    }
}