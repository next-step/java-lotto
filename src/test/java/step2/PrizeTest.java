package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Prize;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @Test
    @DisplayName("일치하는 숫자 갯수에 대응하는 상금 가져오기")
    void getPrizeMoney() {
        // given
        int matchNumber = 4;

        // when
        int expected = Prize.THIRD.getPrizeMoney();
        int actual = Prize.getPrize(matchNumber);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("당첨순위에 따른 상금 계산 테스트")
    void calculateSumOfPrizeMoney() {
        // given
        Map<Integer, Integer> result = new HashMap<>();
        result.put(Prize.FOURTH.getMatchNumber(),0);
        result.put(Prize.THIRD.getMatchNumber(),0);
        result.put(Prize.SECOND.getMatchNumber(),0);
        result.put(Prize.FIRST.getMatchNumber(),1);

        // when
        int actual = Prize.calculateSumOfPrizeMoney(result);

        // then
        int expected = Prize.FIRST.getPrizeMoney();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("수익률 계산하는 테스트")
    void calculateEarningRatio() {
        // given
        int purchasingAmount = 5_000;
        Map<Integer, Integer> result = new HashMap<>();
        result.put(Prize.FOURTH.getMatchNumber(),0);
        result.put(Prize.THIRD.getMatchNumber(),1);
        result.put(Prize.SECOND.getMatchNumber(),0);
        result.put(Prize.FIRST.getMatchNumber(),0);

        // when
        int sumOfPrize = Prize.calculateSumOfPrizeMoney(result);
        double actual = Prize.calculateEarningRatio(sumOfPrize, purchasingAmount);

        // then
        double expected = Prize.THIRD.getPrizeMoney()/purchasingAmount;
        assertEquals(expected, actual);
    }
}
