package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static lotto.domain.LottoRank.FIFTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {
    @DisplayName("로또 발급")
    @Test
    void 로또_발급() {
        LottoGame lottoGame = new LottoGame(30000);
        assertThat(lottoGame.getLottos()).hasSize(30);
    }

    @DisplayName("수익률 구하기")
    @Test
    void 로또_수익률_구하기() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.addResult(FIFTH);
        LottoGame lottoGame = new LottoGame(new LottoPrice(14000), lottoResults);
        assertThat(lottoGame.getEarnRate()).isEqualTo("0.35");
    }
}
