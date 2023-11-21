package study.step3.domain.dto;

import java.util.*;

import study.step3.domain.Rank;

public class Result {

    private final Map<Rank, List<Rank>> map = new LinkedHashMap<>();

    public Result() {
        Arrays.stream(Rank.values())
            .forEach(v -> map.put(v, new ArrayList<>()));
    }

    public void add(Rank rank) {
        map.get(rank).add(rank);
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

    public double toRevenue(int winingAmount, int purchaseAmount) {
        return (double) winingAmount / purchaseAmount;
    }

    public Map<Rank, List<Rank>> map() {
        return map;
    }

    public int size() {
        return map.size();
    }
}
