package lotto.step3.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int prizeMoney;

    Rank(int countOfMatch, int prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonusBall) {
        if (matchBonusBall && isFiveCountOfMatch(countOfMatch)) {
            return SECOND;
        }
        if (isFiveCountOfMatch(countOfMatch)) {
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    private static boolean isFiveCountOfMatch(int countOfMatch) {
        return countOfMatch == THIRD.countOfMatch;
    }

}
