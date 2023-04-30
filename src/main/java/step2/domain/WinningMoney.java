package step2.domain;

import java.util.Arrays;

import static step2.domain.MatchFactory.match;

public enum WinningMoney {

    THREE_MONEY(match(3, false), 5000),
    FOUR_MONEY(match(4, false), 50000),
    FIVE_MONEY(match(5, false), 1500000),
    FIVE_BONUS_MONEY(match(5, true), 30000000),
    SIX_MONEY(match(6, false), 2000000000);

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
