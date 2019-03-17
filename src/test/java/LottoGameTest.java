import domain.LottoGame;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void 금액에_맞는_로또를_구매() {
        int money = 14000;
        LottoGame lottoGame = new LottoGame(money);

        assertThat(lottoGame.getLottos().size()).isEqualTo(14);
    }

    @Test
    public void 금액에_맞는_로또를_구매2() {
        int money = 10000;
        LottoGame lottoGame = new LottoGame(money);

        assertThat(lottoGame.getLottos().size()).isEqualTo(10);
    }

    @Test
    public void 로또를_생성() {
        int money = 10000;
        LottoGame lottoGame = new LottoGame(money);

        assertThat(lottoGame.getLottos().size()).isEqualTo(10);
    }

    @Test
    public void name() {

    }
}
