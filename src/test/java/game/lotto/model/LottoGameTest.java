package game.lotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 게임_만들기() {
        final Money money = new Money(3000);
        final Amount expectedAmount = new Amount(money);
        LottoGame lottoGame = new LottoGame(money);

        assertThat(lottoGame.getAmount()).isEqualTo(expectedAmount);
    }


}