package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    @Test
    void lottoGame() {
        LottoGame lottoGame = new LottoGame(1000);

        assertThat(lottoGame.getBuyAmount()).isEqualTo(1);
    }
}
