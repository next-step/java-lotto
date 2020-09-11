package domain;

import java.util.HashMap;
import java.util.Map;

public class RankRecord {
    public static final int ONE = 1;

    private Map<Rank, Integer> recordPool;

    public RankRecord() {
        this(new HashMap<>());
    }

    public RankRecord(Map<Rank, Integer> pool) {
        recordPool = pool;
        initRecordPool();
    }

    public void initRecordPool() {
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

    public Money sumOfPrice() {
        int totalSum = 0;
        int ea = 0;
        Money price;

        Rank[] ranks = Rank.values();

        for (Rank rank : ranks) {
            ea = recordPool.get(rank);
            price = new Money(rank.getWinnerPrice() * ea);
            totalSum += price.getMoney();
        }

        return new Money(totalSum);
    }

    public int getRecord(Rank rank){
        return recordPool.get(rank);
    }
}
