package lotto;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Prize {
    FIRST(6,2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0,0);

    private final int count;
    private final int money;

    Prize(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public static Prize valueOfCount(int matchCount) {
        return Arrays.stream(values()).filter(prize -> prize.count == matchCount)
            .findFirst()
            .orElse(NONE);
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }
}
