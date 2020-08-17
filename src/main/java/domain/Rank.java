package domain;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int hitNumber;
    private final int money;

    private static final Map<Integer, Rank> Ranks = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(Rank::getHitNumber, Function.identity())));


    Rank(int hitNumber, int money) {
        this.hitNumber = hitNumber;
        this.money = money;
    }

    public int getHitNumber() {
        return hitNumber;
    }

    public int getMoney() {
        return money;
    }

    public static Rank of(int hitNumber) {
        return Ranks.get(hitNumber);
    }

}
