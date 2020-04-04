package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    private GameResult actual;

    @BeforeEach
    void setUp() {
        actual = new GameResult();
        actual.addWinResult(Prize.FOURTH);
    }

    @DisplayName("총 수익률을 보여준다.")
    @Test
    void testGameProfit() {
        // given
        Money purchasedAmount = new Money(14_000);
        long totalPrizeAmount = Prize.FOURTH.getAmount();
        long expected = (totalPrizeAmount / purchasedAmount.getAmount());

        // then
        assertThat(expected).isEqualTo(actual.getProfit(purchasedAmount));
    }
}
