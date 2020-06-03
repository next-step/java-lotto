package study.step3.domain;

import java.util.stream.Stream;

public enum WinningRank {
    NOTHING(0,0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private int matchingCount;
    private long prizeMoney;

    WinningRank(int matchingCount, long prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinningRank findRanking(long inputMatchingCount){
        return Stream.of(values())
                .filter(rank -> isaEqualRank(inputMatchingCount, rank))
                .findFirst()
                .orElse(NOTHING);
    }

    public int getMatchingCount(){
        return matchingCount;
    }

    public long getPrizeMoney(){
        return prizeMoney;
    }

    private static boolean isaEqualRank(long inputMatchingCount, WinningRank rank) {
        return rank.matchingCount == inputMatchingCount;
    }
}
