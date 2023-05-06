package step2.domain;

import java.util.Arrays;

public enum WinningMoney {

    THREE_MONEY(Match.from(3, false), 5000),
    FOUR_MONEY(Match.from(4, false), 50000),
    FIVE_MONEY(Match.from(5, false), 1500000),
    FIVE_BONUS_MONEY(Match.from(5, true), 30000000),
    SIX_MONEY(Match.from(6, false), 2000000000);

    private final Match match;
    private final int money;

    WinningMoney(Match match, int money) {
        this.match = match;
        this.money = money;
    }

    public static Integer winningMoney(Match match) {
        return Arrays.stream(WinningMoney.values())
                .filter(winningMoney -> winningMoney.isEqualMatch(match))
                .findAny()
                .map(winningMoney -> winningMoney.money)
                .orElse(0);
    }

    private boolean isEqualMatch(Match match) {
        return this.match.equals(match);
    }
}
