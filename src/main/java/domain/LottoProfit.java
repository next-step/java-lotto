package domain;

import java.util.Arrays;

public enum LottoProfit {

    MISS(0,0),
    FIFTH(3,5_000),
    FOURTH(4,50_000),
    THIRD(5,1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6,2_000_000_000);

    private static final int WINNING_MIN_MATCH = 3;

    private int numberOfMatch;
    private int prizeMoney;

    LottoProfit(int numberOfMatch, int prizeMoney) {
        this.numberOfMatch = numberOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public static LottoProfit valueOf(int numberOfMatch, boolean matchBonusNo) {
        if (numberOfMatch < WINNING_MIN_MATCH) {
            return MISS;
        }

        if (SECOND.matchCount(numberOfMatch) && matchBonusNo) {
            return SECOND;
        }

        for (LottoProfit profit : values()) {
            if (profit.matchCount(numberOfMatch)) {
                return profit;
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean matchCount(int numberOfMatch) {
        return this.numberOfMatch == numberOfMatch;
    }

}
