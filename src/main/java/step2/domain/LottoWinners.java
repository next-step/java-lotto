package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoWinners {
    Map<Rank, Integer> winner = new HashMap<>();

    public LottoWinners() {
        winner.put(Rank.POSTION_1, 0);
        winner.put(Rank.POSTION_2, 0);
        winner.put(Rank.POSTION_3, 0);
        winner.put(Rank.POSTION_4, 0);
    }

    public void addWiners(int rankMatchCount) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == rankMatchCount)
                winner.put(rank, winner.get(rank) + 1);
        }
    }

    public int countByRank(Rank rank) {
        return winner.get(rank);
    }

    public int totalMoney() {
        int total = 0;
        for (Rank rank : Rank.values()) {
            total += countByRank(rank) * rank.price;
        }
        return total;
    }
}
