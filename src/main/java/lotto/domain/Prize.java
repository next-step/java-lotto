package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private final int count;
    private final int money;

    Prize(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public static Prize fromCount(int count) {
        return Arrays.stream(values())
                .filter(prize -> prize.count == count)
                .findFirst()
                .orElse(NONE);
    }
}
