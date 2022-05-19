package lotto.domain.constant;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    NONE(0, 0);

    private final int correspondCount;
    private final int prizeMoney;

    Rank(int correspondCount, int prizeMoney) {
        this.correspondCount = correspondCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank create(int correspondCount, boolean isContainBonusNumber) {
        Rank rank = Arrays.stream(values()).filter(x -> x.correspondCount == correspondCount)
                .findAny()
                .orElse(NONE);

        return checkSecondOrThird(rank, isContainBonusNumber);
    }

    private static Rank checkSecondOrThird(Rank rank, boolean isContainBonusNumber) {
        if (rank != SECOND && rank != THIRD) {
            return rank;
        }

        if (isContainBonusNumber) {
            return SECOND;
        }

        return THIRD;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCorrespondCount() {
        return correspondCount;
    }
}
