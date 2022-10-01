package com.game.lotto.prize;

public enum PrizeByStrikesEnum {
    FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES(6, 2_000_000_000),
    SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES(5, 1_500_000),
    THIRD_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES(4, 50_000),
    FOURTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES(3, 5_000);

    private final int strikes;
    private final long moneyAmount;

    PrizeByStrikesEnum(int strikes, long moneyAmount) {
        this.strikes = strikes;
        this.moneyAmount = moneyAmount;
    }

    public int getStrikes() {
        return strikes;
    }

    public long getMoneyAmount() {
        return moneyAmount;
    }
}
