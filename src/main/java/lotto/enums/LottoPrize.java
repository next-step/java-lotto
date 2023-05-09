package lotto.enums;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),

    SECOND(5, true, 30_000_000),

    THIRD(5, false, 1_500_000),

    FOURTH(4, 50_000),

    FIFTH(3, 5_000),

    MISS(0, 0);

    private final int matchCount;

    private final boolean hasBonusNumber;

    private final int prizeMoney;

    LottoPrize(int matchCount, int prizeMoney) {
        this(matchCount, false, prizeMoney);
    }

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
                .filter(prize -> prize.matchCount == matchCount && prize.hasBonusNumber == hasBonusNumber)
                .findFirst()
                .orElse(MISS);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean getHasBonusNumber() {
        return hasBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }
}