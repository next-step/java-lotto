package lotto;

import java.util.Arrays;

public enum Prize {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FORTH(5000, 3),
    NONE(0,0);

    private int money;
    private int cnt;

    Prize(int money, int cnt) {
        this.money = money;
        this.cnt = cnt;
    }

    public int getCnt() {
        return this.cnt;
    }

    public int getMoney() {
        return this.money;
    }

    static public Prize matchPrize(int cnt) {
        return Arrays.stream(values()).filter((prize) -> prize.cnt == cnt)
                .findFirst()
                .orElse(NONE);
    }
}
