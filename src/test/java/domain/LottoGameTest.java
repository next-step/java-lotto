package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void 금액에_맞는_로또를_구매() {
        int money = 14_000;
        LottoGame lottoGame = new LottoGame(money);

        assertThat(lottoGame.getLottos().size()).isEqualTo(14);
    }

    @Test
    public void 금액에_맞는_로또를_구매2() {
        int money = 10_000;
        LottoGame lottoGame = new LottoGame(money);

        assertThat(lottoGame.getLottos().size()).isEqualTo(10);
    }
}
