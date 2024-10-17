package lotto.enumeration;

import java.util.Arrays;
import java.util.Objects;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int count;
    private final int price;

    Rank(final int count, final int price) {
        this.count = count;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static Rank rank(final int count) {
        return Arrays.stream(values())
            .filter(rank -> Objects.equals(rank.count, count))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Invalid count " + count));
    }
}
