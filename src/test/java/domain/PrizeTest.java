package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static controller.LottoGame.*;
import static domain.Prize.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeTest {

    @DisplayName("Test of SumProfit function of Prize class")
    @Test
    void testSumProfit() {
        resetPrize();

        countPrize(FIRST_PRIZE_MATCHING_NUMBER);
        assertThat(sumProfit()).isEqualTo(FIRST_PRIZE_REWARD);

        countPrize(THIRD_PRIZE_MATCHING_NUMBER);
        assertThat(sumProfit()).isEqualTo(FIRST_PRIZE_REWARD + THIRD_PRIZE_REWARD);

        countPrize(FOURTH_PRIZE_MATCHING_NUMBER);
        assertThat(sumProfit()).isEqualTo(FIRST_PRIZE_REWARD + THIRD_PRIZE_REWARD + FOURTH_PRIZE_REWARD);
    }
}
