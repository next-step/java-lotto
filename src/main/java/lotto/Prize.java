package lotto;

import java.util.Arrays;

public enum Prize {
    LOSE (0, 0),
    SIXTH(1, 0),
    FIFTH(2, 0),
    FOURTH(3, 5000),
    THIRD(4, 5_0000),
    SECOND(5, 150_0000),
    FIRST(6, 20_0000_0000);

    private final int hitCount;
    private final int money;

    Prize(int hitCount, int money) {
        this.hitCount = hitCount;
        this.money = money;
    }

    public static Prize of(int hitCount) {
        return Arrays.stream(values())
                .filter(p -> p.hitCount == hitCount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int money() {
        return this.money;
    }
    public int hitCount() {
        return this.hitCount;
    }
}
