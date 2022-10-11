package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FOURTH(3,Money.from(5000)),
    THIRD(4, Money.from(50000)),
    SECOND(5, Money.from(1500000)),
    FIRST(6, Money.from(2000000000)),
    NONE(0, Money.from(0));

    public int match;
    public Money money;

    Rank(int match, Money money) {
        this.match = match;
        this.money = money;
    }

    public static Rank calculate(int matchCount) {
        return Arrays.stream(values())
            .filter(rank -> rank.match == matchCount)
            .findFirst()
            .orElse(NONE);
    }

}
