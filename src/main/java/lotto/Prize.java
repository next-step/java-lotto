package lotto;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Prize {
    ONE(6,2000000000),
    TWO(5, 1500000),
    THREE(4, 50000),
    FOUR(3, 50000),
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
            .orElse(null);
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }
}
