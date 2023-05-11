package lotto.domain;

import java.util.Arrays;

public enum RankType {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0,0);

    private final int numberOfMatch;
    private final int prizeMoney;

    RankType(int numberOfMatch, int prizeMoney) {
        this.numberOfMatch = numberOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static RankType findRankType(int numberOfMatch, boolean isMatchBonusNumber) {
        if (numberOfMatch == 5) {
            return isMatchBonusNumber ? SECOND : THIRD;
        }

        return Arrays.stream(values())
                .filter(rankType -> rankType.numberOfMatch == numberOfMatch)
                .findFirst().orElse(MISS);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        return numberOfMatch + "개 일치 (" + prizeMoney + "원)";
    }
}
