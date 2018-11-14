package lotto;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    private LottoGame lottoGame;

    @Before
    public void setup() {
        lottoGame = new LottoGame();
    }

    @Test
    public void buy_구입_금액_0원_수량() {
        assertThat(0).isEqualTo(lottoGame.buy(0).size());
    }

    @Test
    public void buy_구입_금액에_해당하는_로또_수량() {
        assertThat(5).isEqualTo(lottoGame.buy(5000).size());
    }
}
