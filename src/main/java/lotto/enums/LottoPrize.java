package lotto.enums;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, false, 2_000_000_000),

    SECOND(5, true, 30_000_000),

    THIRD(5, false, 1_500_000),

    FOURTH(4, false,50_000),

    FIFTH(3,false, 5_000),

    MISS(0, false, 0);

    private final int matchCount;

    private final boolean hasBonusNumber;

    private final int prizeMoney;

    LottoPrize(int matchCount, boolean hasBonusNumber, int prizeMoney) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize valueOf(int matchCount, boolean hasBonusNumber) {
        if(matchCount == 5 && hasBonusNumber) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(prize -> {
                    if(matchCount == 5) return prize == THIRD;
                    return prize.matchCount == matchCount;
                })
                .findFirst()
                .orElse(MISS);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

}