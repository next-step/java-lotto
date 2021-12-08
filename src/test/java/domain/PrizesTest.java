package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.LottosTest.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizesTest {

    @DisplayName("Test profitRate function of Prizes class")
    @Test
    void testProfitRate() {
        Prizes prizes = LOTTOS.prizes(WINNING_LOTTO, BONUS_NUMBER);

        assertThat(prizes.profitRate(LOTTO_PURCHASE_AMOUNT)).isEqualTo(203_161.5);
    }

    @DisplayName("Test match function of prizes")
    @Test
    void testMatchedNumbers() {
        Prizes prizes = LOTTOS.prizes(WINNING_LOTTO, BONUS_NUMBER);

        assertThat(prizes.match(PrizeCondition.FIFTH)).isEqualTo(3);
        assertThat(prizes.match(PrizeCondition.FOURTH)).isEqualTo(2);
        assertThat(prizes.match(PrizeCondition.THIRD)).isEqualTo(1);
        assertThat(prizes.match(PrizeCondition.SECOND)).isEqualTo(1);
        assertThat(prizes.match(PrizeCondition.FIRST)).isEqualTo(1);
    }
}
