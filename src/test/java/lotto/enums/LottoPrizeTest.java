package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeTest {

    @ParameterizedTest
    @DisplayName("로또 등수와 상금 테스트")
    @CsvSource({
            "FIRST, 2_000_000_000",
            "SECOND, 30_000_000",
            "THIRD, 1_500_000",
            "FOURTH, 50_000",
            "FIFTH, 5_000",
            "MISS, 0"
    })
    void lotto_prize_money_test(LottoPrize lottoPrize, int expectedPrize) {
        assertEquals(expectedPrize, lottoPrize.getPrizeMoney());
    }


    @ParameterizedTest
    @DisplayName("로또 당첨 순위 테스트")
    @CsvSource({"6, FIRST", "5, THIRD", "4, FOURTH", "3, FIFTH", "0, MISS"})
    void lotto_prize_money_rank_test(int value, LottoPrize expected) {
        assertEquals(expected, LottoPrize.valueOf(value, false));
    }

    @Test
    @DisplayName("로또 당첨 순위 테스트")
    void lotto_prize_money_rank_second() {
        assertEquals(LottoPrize.SECOND, LottoPrize.valueOf(5, true));
    }

}