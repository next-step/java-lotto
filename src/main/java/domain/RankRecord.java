package domain;

public class RankRecord {
    public static final int RECORD_SIZE = 7;
    private int[] recordPool;

    public RankRecord() {
        recordPool = new int[RECORD_SIZE];
    }

    public int[] getRecordPool() {
        return recordPool;
    }
}
