package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;

public class LottoResult {
    private LinkedHashMap<Rank, Integer> rankCounts;

    public LottoResult() {
        this.rankCounts = new LinkedHashMap<Rank, Integer>();
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NON_RANKED))
                .forEach(rank -> rankCounts.put(rank, 0));
    }

    public void put(Rank rank) {
        rankCounts.merge(rank, 1, Integer::sum);
    }

    public double calculateProfitRate(int amount) {
        return (double) calculateTotalPrize() / (double) amount;
    }

    private int calculateTotalPrize() {
        return getRanks().stream()
                .map(rank -> rank.getPrize() * getRankCount(rank))
                .reduce(0, Integer::sum);
    }

    public Set<Rank> getRanks() {
        return rankCounts.keySet();
    }

    public Integer getRankCount(Rank rank) {
        return rankCounts.get(rank);
    }
}
