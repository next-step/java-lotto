package lotto.domain;

import lotto.common.ErrorMessage;

import java.util.Arrays;

public enum Prize {
    THREE_NUMBER_MATCH(3, 5000),
    FOUR_NUMBER_MATCH(4, 50000),
    FIVE_NUMBER_MATCH(5, 1500000),
    SIX_NUMBER_MATCH(6, 2000000000);
    
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
            .orElse(null);
    }
    
    public int getMatchCount() {
        return matchCount;
    }
    
    public long getPrizeMoney() {
        return prizeMoney;
    }
}
