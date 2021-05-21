package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private GameResult gameResult;


    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
        gameResult.addWinResult(Prize.FOURTH);
    }

    @DisplayName("로또 게임의 총 수익률을 리턴한다.")
    @Test
    void getGameProfit() {
        // given
        final Money purchasedAmount = new Money(20_000);

        // when
        double actual = gameResult.getProfit(purchasedAmount);

        // then
        assertThat(actual).isEqualTo(2.5);
    }
}
