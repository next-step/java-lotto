package domain;

import java.util.HashMap;
import java.util.Map;

public class RankRecord {
    public static final int ONE = 1;

    private Map<Rank, Integer> recordPool;

    public RankRecord() {
        recordPool = new HashMap<>();

        Rank[] ranks = Rank.values();

        for (Rank rank : ranks) {
            recordPool.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getRecordPool() {
        return recordPool;
    }

    public void recordOfRankings(Rank ranking) {
        int rankCount = recordPool.get(ranking);
        recordPool.put(ranking, rankCount + ONE);
    }

    public int sumOfPrice() {
        int sum = 0;
        int ea = 0;
        int price = 0;
        Rank[] ranks = Rank.values();

        for (Rank rank : ranks) {
            ea = recordPool.get(rank);
            price = rank.getWinnerPrice();
            sum += ea * price;
        }
        return sum;
    }
}
