package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Winners {
    Map<Rank, Integer> winnersMap;

    public Winners() {
        winnersMap = new HashMap<>();
        for (Rank r : Rank.values()) {
            winnersMap.put(r, 0);
        }
    }

    public int wins(Rank rank) {
        return winnersMap.get(rank);
    }

    public void increase(Rank rank) {
        int wins = winnersMap.get(rank);
        winnersMap.put(rank, wins + 1);
    }

    public double yield(int cost) {
        double totalPrize = 0;
        for (Rank r : Rank.values()) {
            totalPrize = totalPrize + r.prize() * wins(r);
        }
        return totalPrize / cost;
    }
}
