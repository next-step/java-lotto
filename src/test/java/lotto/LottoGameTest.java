package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.LottoGame.CAN_NOT_BUY_LOTTO;
import static lotto.domain.LottoGame.CAN_NOT_BUY_LOTTO_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {
    @DisplayName("로또 발급")
    @Test
    void 로또_발급() {
        LottoGame lottoGame = new LottoGame(30000);
        assertThat(lottoGame.getLottoList()).hasSize(30);
    }

    @DisplayName("로또 금액 0이하")
    @Test
    void 로또_금액_0이하_에러() {
        assertThatThrownBy(() -> {
            new LottoGame(0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAN_NOT_BUY_LOTTO);
    }

    @DisplayName("로또 금액 1000단위 아닌 에러")
    @Test
    void 로또_금액_1000단위_에러() {
        assertThatThrownBy(() -> {
            new LottoGame(1001);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAN_NOT_BUY_LOTTO_AMOUNT);
    }

    @DisplayName("수익률 구하기")
    @Test
    void 로또_수익률_구하기() {
        Map<Integer, Integer> result = new HashMap<>();
        LottoResults lottoResults = new LottoResults();
        lottoResults.addResult(5);
        LottoGame lottoGame = new LottoGame(14000, lottoResults);

        assertThat(lottoGame.getEarnRate()).isEqualTo("0.35");
    }
}
