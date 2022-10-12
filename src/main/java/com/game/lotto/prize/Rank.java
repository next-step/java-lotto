package com.game.lotto.prize;

public enum Rank {
    FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES(6, 2_000_000_000),
    SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES_AND_BONUS(5, 30_000_000),
    THIRD_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES(5, 1_500_000),
    FOURTH_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES(4, 50_000),
    FIFTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES(3, 5_000),
    NONE(0, 0);

    private final int strikes;
    private final long moneyAmount;

    Rank(int strikes, long moneyAmount) {
        this.strikes = strikes;
        this.moneyAmount = moneyAmount;
    }

    public int getStrikes() {
        return strikes;
    }

    public long getMoneyAmount() {
        return moneyAmount;
    }

    public static Rank valueOf(int strikes) {
        if(strikes == 6) return FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES;
        if(strikes == 5) return THIRD_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES;
        if(strikes == 4) return FOURTH_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES;
        if(strikes == 3) return FIFTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES;
        return NONE;
    }
}
