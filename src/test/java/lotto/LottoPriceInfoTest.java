package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPriceInfoTest {

    @DisplayName("티켓수에 따른 상금 계산")
    @Test
    void calculatePrice() {
        //given
        int expected = 5_000;

        //when
        int actual = LottoPriceInfo.LOTTO_RANK_4.calculatePrice(1);

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("총 상금 계산")
    @Test
    void calculateTotalPrice() {
        //given
        Map<Integer, Integer> matchResult = new HashMap<>();
        matchResult.put(3, 1);
        matchResult.put(4, 1);
        int expected = 55_000;
        //when
        int actual = LottoPriceInfo.calculateTotalPrice(matchResult);

        //then
        assertEquals(expected, actual);
    }
}