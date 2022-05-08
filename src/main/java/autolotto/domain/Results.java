package autolotto.domain;

import autolotto.constant.Rank;

import java.util.*;

public class Results {
    private final Map<Rank, Integer> results = new LinkedHashMap<>();

    public void plusWinners(Rank rank) {
        int winners = results.getOrDefault(rank, 0);
        results.put(rank, ++winners);
    }

    public int countOfWinners(Rank rank) {
        return results.getOrDefault(rank, 0);
    }

    public double roi(int cost) {
        return (double) profit() / cost * 100;
    }

    long profit() {
        return results.keySet()
                .stream()
                .mapToLong(rank -> rank.getWinningMoney() * countOfWinners(rank))
                .sum();
    }
}
