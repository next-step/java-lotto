package study.step2.domain;

import java.util.stream.Stream;

public enum WinningTable {
    NOTHING(0,0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int matchingCount;
    private long prizeMoney;

    WinningTable(int matchingCount, long prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinningTable findRanking(int inputMatchingCount){
        return Stream.of(WinningTable.values())
                .filter(value -> isaEqualRank(inputMatchingCount, value))
                .findFirst()
                .orElse(NOTHING);
    }

    public int getMatchingCount(){
        return matchingCount;
    }

    public long getPrizeMoney(){
        return prizeMoney;
    }

    private static boolean isaEqualRank(int inputMatchingCount, WinningTable value) {
        return value.matchingCount == inputMatchingCount;
    }
}
