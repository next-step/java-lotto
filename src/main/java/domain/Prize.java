package domain;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int hitNumber;
    private final int money;

    private static final Map<Integer, Prize> prizes = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(Prize::getHitNumber, Function.identity())));


    Prize(int hitNumber, int money) {
        this.hitNumber = hitNumber;
        this.money = money;
    }

    public int getHitNumber() {
        return this.hitNumber;
    }

    public int getMoney() {
        return money;
    }

    public static Prize of(int hitNumber) {
        return prizes.get(hitNumber);
    }

}
