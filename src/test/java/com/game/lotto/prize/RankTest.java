package com.game.lotto.prize;

import org.junit.jupiter.api.Test;

import static com.game.lotto.prize.Rank.*;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void compare_strikes() {
        assertEquals(6, FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES.getStrikes().getCount());
        assertEquals(5, SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES_AND_BONUS.getStrikes().getCount());
        assertEquals(5, THIRD_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES.getStrikes().getCount());
        assertEquals(4, FOURTH_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES.getStrikes().getCount());
        assertEquals(3, FIFTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES.getStrikes().getCount());
        assertEquals(0, NONE.getStrikes().getCount());
    }

    @Test
    void compare_money_amount() {
        assertEquals(2_000_000_000, FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES.getMoneyAmount().getAmount());
        assertEquals(30_000_000, SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES_AND_BONUS.getMoneyAmount().getAmount());
        assertEquals(1_500_000, THIRD_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES.getMoneyAmount().getAmount());
        assertEquals(50_000, FOURTH_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES.getMoneyAmount().getAmount());
        assertEquals(5_000, FIFTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES.getMoneyAmount().getAmount());
        assertEquals(0, NONE.getMoneyAmount().getAmount());
    }
}