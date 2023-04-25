package step2.domain;

import java.util.Arrays;

public enum WinningMoney {

    THREE_MONEY(3, 5000),
    FOUR_MONEY(4, 50000),
    FIVE_MONEY(5, 1500000),
    SIX_MONEY(6, 2000000000);

    private final int match;
    private final int money;

    WinningMoney(int match, int money) {
        this.match = match;
        this.money = money;
    }

    public static Integer winningMoney(int match) {
        return Arrays.stream(WinningMoney.values())
                .filter(winningMoney -> winningMoney.isEqualMatch(match))
                .findAny()
                .map(winningMoney -> winningMoney.money)
                .orElse(0);
    }

    private boolean isEqualMatch(int match) {
        return this.match == match;
    }
}
