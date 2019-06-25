package lotto.domain;

import java.util.Arrays;

public enum Prize {
    NOT_MATCH(0, 0),
    THREE_NUMBER_MATCH(3, 5_000),
    FOUR_NUMBER_MATCH(4, 50_000),
    FIVE_NUMBER_MATCH(5, 1_500_000),
    SIX_NUMBER_MATCH(6, 2_000_000_000);
    
    private int matchCount;
    private long prizeMoney;
    
    Prize(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }
    
    public static Prize getPrize(int matchCount) {
        return Arrays.stream(Prize.values())
            .filter(prize -> prize.matchCount == matchCount)
            .findFirst()
            .orElse(Prize.NOT_MATCH);
    }
    
    public int getMatchCount() {
        return matchCount;
    }
    
    public long getPrizeMoney() {
        return prizeMoney;
    }
}
