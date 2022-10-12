package com.game.lotto.prize;

import org.junit.jupiter.api.Test;

import static com.game.lotto.prize.Rank.*;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void compare_strikes() {
        assertEquals(6, FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES.getStrikes());
        assertEquals(5, SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES.getStrikes());
        assertEquals(4, THIRD_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES.getStrikes());
        assertEquals(3, FOURTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES.getStrikes());
    }

    @Test
    void compare_money_amount() {
        assertEquals(2_000_000_000, FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES.getMoneyAmount());
        assertEquals(1_500_000, SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES.getMoneyAmount());
        assertEquals(50_000, THIRD_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES.getMoneyAmount());
        assertEquals(5_000, FOURTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES.getMoneyAmount());
    }
}