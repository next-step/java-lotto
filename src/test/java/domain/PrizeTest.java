package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeTest {

    @DisplayName("Test of Profit function of Prize class")
    @Test
    void testProfit() {
        Prize prize = new Prize(PrizeCondition.FIFTH, 3);
        assertThat(prize.profit()).isEqualTo(PrizeCondition.FIFTH.getReward() * 3);
    }

    @DisplayName("Test of incrementedPrize function of Prize class")
    @Test
    void testIncrementedPrize() {
        Prize prize = new Prize(PrizeCondition.FIFTH, 3);
        assertThat(prize.incrementedPrize()).isEqualTo(new Prize(PrizeCondition.FIFTH, 4));
    }
}
