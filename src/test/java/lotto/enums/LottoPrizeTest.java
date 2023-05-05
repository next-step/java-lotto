package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeTest {

    @ParameterizedTest
    @DisplayName("로또 등수와 상금 테스트")
    @CsvSource({
            "FIRST, 2000000000",
            "SECOND, 1500000",
            "THIRD, 50000",
            "FOURTH, 5000",
            "MISS, 0"
    })
    void lotto_prize_money_test(LottoPrize lottoPrize, int expectedPrize) {
        assertEquals(expectedPrize, lottoPrize.getPrizeMoney());
    }

    @ParameterizedTest
    @DisplayName("로또 당첨 금액 포맷 테스트")
    @CsvSource(value = {"2,000,000,000: 6", "1,500,000: 5", "50,000: 4", "5,000: 3", "0: 0"}, delimiter = ':')
    void lotto_prize_money_format_test(String value, int number) {
        // When & Then
        assertEquals(value, LottoPrize.valueOf(number).getPrizeMoneyFormat());
    }

    @ParameterizedTest
    @DisplayName("로또 당첨 순위 테스트")
    @CsvSource({"6, FIRST", "5, SECOND", "4, THIRD", "3, FOURTH", "0, MISS"})
    void lotto_prize_money_rank_test(int value, LottoPrize expected) {
        assertEquals(expected, LottoPrize.valueOf(value));
    }

}