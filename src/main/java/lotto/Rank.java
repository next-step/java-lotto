package lotto;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Rank {

    FIRST(6, Money.from(2000000000), match -> match == 6),
    SECOND(5, Money.from(1500000), match -> match == 5),
    THIRD(4, Money.from(50000), match -> match == 4),
    FOURTH(3,Money.from(5000), match -> match == 3),
    NONE(0, Money.from(0), match -> match < 3);

    int match;
    Money money;
    Predicate<Integer> isPredicted;
    Rank(int match, Money money, Predicate<Integer> isPredicted) {
        this.match = match;
        this.money = money;
        this.isPredicted = isPredicted;
    }

    public static Rank calculate(int matchCount) {
        return Arrays.stream(values())
            .filter(rank -> rank.isPredicted.test(matchCount))
            .findFirst()
            .orElse(NONE);
    }

}
