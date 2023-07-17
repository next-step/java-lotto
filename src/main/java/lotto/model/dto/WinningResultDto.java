package lotto.model.dto;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import lotto.model.Rank;
import lotto.model.WinningResult;

public class WinningResultDto {

    private final Map<Rank, Integer> ranks;
    private final double profit;

    WinningResultDto(final Map<Rank, Integer> ranks, final double profit) {
        this.ranks = ranks;
        this.profit = profit;
    }

    public static WinningResultDto from(final WinningResult winningResult) {
        Map<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            if (rank == Rank.DEFAULT) {
                continue;
            }
            ranks.put(rank, winningResult.getRankCount(rank));
        }
        return new WinningResultDto(ranks, winningResult.getProfit());
    }

    public double floorProfit() {
        return Math.floor(100 * this.profit) / 100.0;
    }

    public Set<Rank> getRanks() {
        return this.ranks.keySet();
    }

    public int getCount(Rank rank) {
        return ranks.get(rank);
    }
}
