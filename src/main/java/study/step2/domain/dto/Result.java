package study.step2.domain.dto;

import java.util.*;

import study.step2.domain.Rank;

public class Result {

    private final Map<Rank, List<Rank>> map = new LinkedHashMap<>();

    public Result() {
        Rank.valuesToList()
            .forEach(v -> map.put(v, new ArrayList<>()));
    }

    public void add(Rank rank) {
        if (map.containsKey(rank)) {
            map.get(rank).add(rank);
        }
    }

    public int size(Rank rank) {
        return map.get(rank).size();
    }

    public int totalWiningAmount() {
        int sum = 0;
        for (Rank rank: map.keySet()) {
            sum += (rank.amount() * map.get(rank).size());
        }
        return sum;
    }

    public float toRevenue(int winingAmount, int purchaseAmount) {
        return (float) winingAmount / purchaseAmount;
    }

    public Map<Rank, List<Rank>> map() {
        return map;
    }

    public int size() {
        return map.size();
    }
}
