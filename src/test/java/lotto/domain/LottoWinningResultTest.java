package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningResultTest {
    @Test
    @DisplayName("당첨된 금액을 구할 수 있다.")
    void shouldCalculateTotalWinningPrice() {
        final LottoResultBundle resultBundle = new LottoResultBundle();
        resultBundle.add(Lotto.createAutoLotto());
        resultBundle.add(Lotto.createAutoLotto());
        resultBundle.add(Lotto.createAutoLotto());
        final LottoWinningResult lottoWinningResult = new LottoWinningResult(LottoRank.FIFTH, resultBundle);

        assertThat(lottoWinningResult.totalWinningPrice()).isEqualTo(15000);
    }
}