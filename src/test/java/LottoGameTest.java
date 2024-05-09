import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void 로또는_1000원당_1개_구입할수있다() {
        LottoGame lottoGame = new LottoGame();
        int budget = 5000;

        Lottos lottos = lottoGame.buy(budget);
        assertThat(lottos.size()).isEqualTo(budget / 1000);
    }
}
