package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPriceInfoTest {
    @DisplayName("티켓수에 따른 상금 계산")
    @Test
    void calculatePrice() {
        int expected = 5_000;
        int actual = LottoPriceInfo.MATCH_COUNT_3.calculatePrice(1);
    }
}