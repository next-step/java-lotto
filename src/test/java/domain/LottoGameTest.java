package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    private LottoGame lottoGame;

    @Before
    public void setup() {
        lottoGame = new LottoGame();
    }

    @Test
    public void 가격으로_개수구하기() {
        lottoGame.buyLotto(14000);
        assertThat(lottoGame.getLottoCount()).isEqualTo(14);
    }
}
