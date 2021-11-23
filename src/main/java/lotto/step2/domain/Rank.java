package lotto.step2.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Rank {

    FIRST(6, 2_000_000_000),
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

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter(isSameCountOfMatch(countOfMatch))
                .findFirst()
                .orElse(MISS);
    }

    private static Predicate<Rank> isSameCountOfMatch(int countOfMatch) {
        return rank -> rank.getCountOfMatch() == countOfMatch;
    }

}
