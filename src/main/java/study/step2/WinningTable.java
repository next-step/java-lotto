package study.step2;

import java.util.stream.Stream;

public enum WinningTable {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private int machingCount;
    private long prizeMoney;

    WinningTable(int machingCount, long prizeMoney) {
        this.machingCount = machingCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinningTable findRanking(int inputMachingCount){
        return Stream.of(WinningTable.values())
                .filter(value -> isaEqualRank(inputMachingCount, value))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("당첨 순위에 없는 일치 횟수 입니다."));
    }

    public int getMachingCount(){
        return machingCount;
    }

    public long getPrizeMoney(){
        return prizeMoney;
    }

    private static boolean isaEqualRank(int inputMachingCount, WinningTable value) {
        return value.machingCount == inputMachingCount;
    }
}
