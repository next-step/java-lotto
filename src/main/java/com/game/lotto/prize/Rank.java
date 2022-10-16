package com.game.lotto.prize;

import com.game.lotto.money.Money;
import com.game.lotto.count.Strike;

import java.util.Arrays;

public enum Rank {
    FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES(6, 2_000_000_000, false),
    SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES_AND_BONUS(5, 30_000_000, true),
    THIRD_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES(5, 1_500_000, false),
    FOURTH_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES(4, 50_000, false),
    FIFTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES(3, 5_000, false),
    NONE(0, 0, false);

    private final Strike strikes;
    private final Money moneyAmount;
    private final boolean needBonusBall;

    Rank(int strikes, int moneyAmount, boolean needBonusBall) {
        this.strikes = new Strike(strikes);
        this.moneyAmount = new Money(moneyAmount);
        this.needBonusBall = needBonusBall;
    }

    public Strike getStrikes() {
        return strikes;
    }

    public Money getMoneyAmount() {
        return moneyAmount;
    }

    public static Rank valueOf(Strike strikes, boolean isMyNumbersContainsBonusBall) {
        if (strikes.getCount() == 5 && isMyNumbersContainsBonusBall) {
            return SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES_AND_BONUS;
        }

        return Arrays.stream(values())
                .filter(rank -> !rank.needBonusBall)
                .filter(rank -> rank.strikes.equals(strikes))
                .findAny()
                .orElse(NONE);
    }
}
