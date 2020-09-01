package domain;

import java.util.ArrayList;
import java.util.List;

public class RankRecord {
    public static final int RECORD_SIZE = 6;
    public static final int ONE = 1;

    private List<Integer> recordPool;

    public RankRecord() {
        recordPool = new ArrayList<>();

        for (int i = 0; i < RECORD_SIZE; i++) {
            recordPool.add(0);
        }
    }

    public List<Integer> getRecordPool() {
        return recordPool;
    }

    public void recordOfRankings(Rank ranking) {
        int rank = ranking.ordinal() + ONE;

        int rankCount = recordPool.get(rank);
        recordPool.set(rank, rankCount + ONE);
    }

    public int sumOfPrice() {
        int sum = 0;
        int ea = 0;
        int price = 0;
        Rank[] ranks = Rank.values();

        for (int i = 1; i < RECORD_SIZE; i++) {
            ea = recordPool.get(i);
            price = ranks[i - 1].getWinnerPrice();
            sum += ea * price;
        }
        return sum;
    }
}
