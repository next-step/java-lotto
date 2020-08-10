package domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoGameWinningMoneyType {
    FIRST_WINNING_MONEY(2000000000),
    SECOND_WINNING_MONEY(1500000),
    THIRD_WINNING_MONEY(50000),
    FORTH_WINNING_MONEY(5000),
    NOTHING(0);

    private final int money;

    LottoGameWinningMoneyType(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
