package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, Money.from(2_000_000_000)),
    SECOND(5, Money.from(30_000_000)),
    THIRD(5, Money.from(1_500_000)),
    FOURTH(4, Money.from(50_000)),
    FIFTH(3, Money.from(5_000)),
    MISS(0, Money.from(0));

    private final int matchCount;
    private final Money money;

    Rank(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank rank = Arrays.stream(Rank.values())
                .filter(e -> countOfMatch == e.matchCount())
                .findFirst()
                .orElse(Rank.MISS);

        if (countOfMatch == 5 && !matchBonus) {
            return Rank.THIRD;
        }

        return rank;
    }

    public int matchCount() {
        return matchCount;
    }

    public Money money() {
        return money;
    }

}
