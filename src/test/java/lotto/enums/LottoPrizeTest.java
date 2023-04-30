package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeTest {

    @Test
    @DisplayName("로또 당첨 금액 테스트")
    void lotto_prize_money_test() {

        // When & Then
        assertAll(
                () -> assertEquals(2_000_000_000, LottoPrize.FIRST.getPrizeMoney()),
                () -> assertEquals(1_500_000, LottoPrize.SECOND.getPrizeMoney()),
                () -> assertEquals(50_000, LottoPrize.THIRD.getPrizeMoney()),
                () -> assertEquals(5_000, LottoPrize.FOURTH.getPrizeMoney()),
                () -> assertEquals(0, LottoPrize.NONE.getPrizeMoney())
        );
    }


    @Test
    @DisplayName("로또 당첨 금액 포맷 테스트")
    void lotto_prize_money_format_test() {

        // When & Then
        assertAll(
                () -> assertEquals("2,000,000,000", LottoPrize.FIRST.getPrizeMoneyFormat()),
                () -> assertEquals("1,500,000", LottoPrize.SECOND.getPrizeMoneyFormat()),
                () -> assertEquals("50,000", LottoPrize.THIRD.getPrizeMoneyFormat()),
                () -> assertEquals("5,000", LottoPrize.FOURTH.getPrizeMoneyFormat()),
                () -> assertEquals("0", LottoPrize.NONE.getPrizeMoneyFormat())
        );
    }

    @Test
    @DisplayName("로또 당첨 순위 테스트")
    void lotto_prize_money_rank_test() {

        // When & Then
        assertAll(
                () -> assertEquals(LottoPrize.FIRST, LottoPrize.valueOf(6)),
                () -> assertEquals(LottoPrize.SECOND, LottoPrize.valueOf(5)),
                () -> assertEquals(LottoPrize.THIRD, LottoPrize.valueOf(4)),
                () -> assertEquals(LottoPrize.FOURTH, LottoPrize.valueOf(3)),
                () -> assertEquals(LottoPrize.NONE, LottoPrize.valueOf(0))
        );
    }

}