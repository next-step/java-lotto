package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningRank {

    private static final int DEFAULT_VALUE = 0;
    private static final int UPDATE_VALUE = 1;
    private static final double TICKET_PRICE = 1000l;

    private Map<Rank, Integer> winningRank;
    private double count = 0d;

    public WinningRank() {
        this.winningRank = new EnumMap<>(Rank.class);
    }

    public WinningRank updateRank(List<Long> winnerCount) {
        for (Long count : winnerCount) {
            Rank rank = Rank.equalToCount(count);
            winningRank.put(rank, winningRank.getOrDefault(rank, DEFAULT_VALUE) + UPDATE_VALUE);
            this.count = this.count + UPDATE_VALUE;
        }
        return this;
    }

    public double getMoney() {
        return count * TICKET_PRICE;
    }

    public double getPrizeMoney() {
        return (double) winningRank.keySet()
            .stream()
            .mapToLong(rank -> rank.calculatePrizeMoney(winningRank.get(rank)))
            .sum();
    }

    public Map<Rank, Integer> getWinningRank() {
        return Collections.unmodifiableMap(winningRank);
    }

}
