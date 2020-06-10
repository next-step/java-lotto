package study.step4.domain;

import java.util.stream.Stream;

public enum WinningRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOTHING(0,0);

    private static final int MATCH_COUNT_FIVE = 5;

    private int matchingCount;
    private long prizeMoney;

    WinningRank(int matchingCount, long prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinningRank findRanking(long inputMatchingCount, boolean matchBonus){
        if (inputMatchingCount == MATCH_COUNT_FIVE && !matchBonus){
            return WinningRank.THIRD;
        }

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