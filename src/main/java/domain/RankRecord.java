package domain;

import java.util.ArrayList;
import java.util.List;

public class RankRecord {
    public static final int RECORD_SIZE = 6;
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

    public void recordRankings(int count){
        int rank = 6 - count+1 ;

        int rankCount = recordPool.get(rank);
        recordPool.set(rank,rankCount+1);

    }
}
