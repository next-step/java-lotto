package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.PrizeCalculator;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class PrizeCalculatorTest {

    private PrizeCalculator prizeCalculator = new PrizeCalculator();

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateProfitRatioTest(){
        Map<Integer, Integer> winningTicketCategories = new HashMap<>();
        winningTicketCategories.put(Constant.LOTTO_PRIZE_FIRST, Constant.ZERO);
        winningTicketCategories.put(Constant.LOTTO_PRIZE_SECOND, Constant.ZERO);
        winningTicketCategories.put(Constant.LOTTO_PRIZE_THIRD, Constant.COUNT_ONE);
        winningTicketCategories.put(Constant.LOTTO_PRIZE_FOURTH, Constant.ZERO);

        assertThat(prizeCalculator.calculateProfitRatio(winningTicketCategories, 50000)).isEqualTo(1);
    }

}
