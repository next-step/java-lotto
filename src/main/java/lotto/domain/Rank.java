package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIFTH(3,Money.from(5000)),
    FOURTH(4, Money.from(50000)),
    THIRD(5, Money.from(1500000)),
    SECOND(5, Money.from(30000000)),
    FIRST(6, Money.from(2000000000)),
    NONE(0, Money.from(0));

    public int match;
    public Money money;

    Rank(int match, Money money) {
        this.match = match;
        this.money = money;
    }

    public static Rank calculate(int matchCount, boolean bonus) {
        if (matchCount == SECOND.match && bonus) {
            return SECOND;
        }
        return Arrays.stream(values())
            .filter(rank -> rank.match == matchCount)
            .findFirst()
            .orElse(NONE);
    }

}
