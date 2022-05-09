package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    @DisplayName("15000원을 입력 시 15개의 로또를 반환한다.")
    void createLottos() {
        LottoGame lottoGame = new LottoGame(15000);

        assertThat(lottoGame.lottos().count()).isEqualTo(15);
    }
}