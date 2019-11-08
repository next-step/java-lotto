package lotto.domain2;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FIRTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private final int countOfMatch;
    private final int money;

    Rank(final int countOfMatch, final int money) {
        this.countOfMatch = countOfMatch;
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public static Rank findByCountOfMatch(final int countOfMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findAny()
                .orElse(Rank.LOSE);
    }
}
