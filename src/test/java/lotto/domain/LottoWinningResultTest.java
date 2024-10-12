package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningResultTest {
    @Test
    @DisplayName("당첨된 금액을 구할 수 있다.")
    void shouldCalculateTotalWinningPrice() {
        final LottoWinningResult lottoWinningResult = new LottoWinningResult(LottoRank.FIFTH, LottoBundle.createLottoBundle(3));

        assertThat(lottoWinningResult.totalWinningPrice()).isEqualTo(15000);
    }
}