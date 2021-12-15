package lotto.domain;

import java.util.Arrays;

public enum PrizeType {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0),
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

    public static PrizeType of(int countOfMatch) {
        return Arrays.stream(values()).filter(type -> type.countOfMatch == countOfMatch).findAny().orElse(PrizeType.MISS);
    }
}
