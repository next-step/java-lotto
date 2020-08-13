package domain;

import org.junit.jupiter.api.Test;
import strategy.RandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    @Test
    void lottoGame() {
        LottoGame lottoGame = new LottoGame(1000);

        assertThat(lottoGame.getBuyAmount()).isEqualTo(1);
    }

    @Test
    void issue() {
        LottoGame lottoGame = new LottoGame(10000);

        List<Lotto> issuedLottos = lottoGame.issue(new RandomNumberGenerator());

        assertThat(issuedLottos.size()).isEqualTo(10);

    }
}
