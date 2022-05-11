package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    @DisplayName("15000원으로 로또 게임 생성 시 15개의 로또를 생성한다.")
    void initialize() {
        LottoGame lottoGame = new LottoGame(15000);

        assertThat(lottoGame.lottos().count()).isEqualTo(15);
    }
}