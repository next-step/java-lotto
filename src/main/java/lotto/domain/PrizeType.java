package lotto.domain;

import java.util.Arrays;

public enum PrizeType {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    private int countOfMatch;
    private int prizeMoney;

    PrizeType(int countOfMatch, int prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public static PrizeType of(long countOfMatch, boolean hasBonusNumber) {
        return Arrays.stream(values()).filter(type -> type.countOfMatch == countOfMatch)
                .findFirst()
                .map(prizeType -> arrange(prizeType, hasBonusNumber))
                .orElse(PrizeType.MISS);
    }

    private static PrizeType arrange(PrizeType prizeType, boolean hasBonusNumber) {
        if (prizeType == THIRD && hasBonusNumber) {
            return SECOND;
        }
        return prizeType;
    }
}
