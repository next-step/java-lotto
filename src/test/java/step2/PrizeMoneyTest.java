package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.PrizeMoney;

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

    @Test
    @DisplayName("구입금액대비 상금 수익률 계산")
    void calculateEarningRatio() {
        // given
        int purchasingAmount = 14_000;
        Map<Integer, Integer> result = new HashMap<>();
        result.put(PrizeMoney.MATCH_NUMBERS_NEED_TO_FIRST_GRADE, 0);
        result.put(PrizeMoney.MATCH_NUMBERS_NEED_TO_SECOND_GRADE, 0);
        result.put(PrizeMoney.MATCH_NUMBERS_NEED_TO_THIRD_GRADE, 0);
        result.put(PrizeMoney.MATCH_NUMBERS_NEED_TO_FOURTH_GRADE, 1);

        double expected = (double) PrizeMoney.PRIZE_MONEY_FOR_FOURTH_GRADE/purchasingAmount;

        // when
        PrizeMoney prizeMoney = new PrizeMoney();
        prizeMoney.calculateSumOfPrizeMoney(result);
        double actual = prizeMoney.calculateEarningRatio(purchasingAmount);

        // then
        assertEquals(expected, actual);
    }
}
