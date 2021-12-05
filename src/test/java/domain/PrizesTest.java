package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.LottosTest.LOTTOS;
import static domain.LottosTest.WINNING_LOTTO;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizesTest {

    @DisplayName("Test profitRate function of Prizes class")
    @Test
    void testProfitRate() {
        Prizes prizes = new Prizes();

        assertThat(prizes.profitRate(LOTTOS, WINNING_LOTTO)).isEqualTo(200_311.5);
    }
}
