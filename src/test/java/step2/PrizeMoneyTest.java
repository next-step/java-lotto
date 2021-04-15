package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PrizeMoneyTest {

    @Test
    @DisplayName("로또 번호 비교 결과에 따른 상금 계산 테스트")
    void calculateSumOfPrizeMoney() {
        // given
        Map<Integer, Integer> result = new HashMap<>();
        result.put(PrizeMoney.MATCH_NUMBERS_NEED_TO_FIRST_GRADE, 0);
        result.put(PrizeMoney.MATCH_NUMBERS_NEED_TO_SECOND_GRADE, 0);
        result.put(PrizeMoney.MATCH_NUMBERS_NEED_TO_THIRD_GRADE, 2);
        result.put(PrizeMoney.MATCH_NUMBERS_NEED_TO_FOURTH_GRADE, 0);

        // when
        PrizeMoney prizeMoney = new PrizeMoney();
        prizeMoney.calculateSumOfPrizeMoney(result);
        int actual = prizeMoney.getSumOfPrizeMoney();

        // then
        int expected = PrizeMoney.PRIZE_MONEY_FOR_THIRD_GRADE*2;
        assertEquals(expected, actual);
    }
}
