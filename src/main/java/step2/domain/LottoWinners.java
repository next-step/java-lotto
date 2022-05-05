package step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoWinners {
    Map<Rank, Integer> winner = new HashMap<>();

    public LottoWinners() {
        winner.put(Rank.RANK_1, 0);
        winner.put(Rank.RANK_2, 0);
        winner.put(Rank.RANK_3, 0);
        winner.put(Rank.RANK_4, 0);
        winner.put(Rank.RANK_5, 0);
    }

    public void addWiners(Rank rank) {
        if (rank == Rank.NO_RANK)
            return;

        winner.put(rank, winner.get(rank) + 1);
    }

    public int countByRank(Rank rank) {
        return winner.get(rank);
    }

    public int totalMoney() {
        int total = 0;
        for (Rank rank : winner.keySet()) {
            total += countByRank(rank) * rank.price;
        }
        return total;
    }

    public Set<Rank> ranks() {
        return winner.keySet();
    }
}
