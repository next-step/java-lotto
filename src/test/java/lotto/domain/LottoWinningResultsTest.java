package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningResultsTest {
    @Test
    @DisplayName("당첨된 금액을 구할 수 있다.")
    void shouldCalculateTotalWinningPrice() {
        final LottoWinningResult lottoWinningResult1 = new LottoWinningResult(LottoRank.fifth(), LottoBundle.createLottoBundle(3));
        final LottoWinningResult lottoWinningResult2 = new LottoWinningResult(LottoRank.fourth(), LottoBundle.createLottoBundle(1));
        final LottoWinningResults lottoWinningResults = new LottoWinningResults(List.of(lottoWinningResult1, lottoWinningResult2));

        assertThat(lottoWinningResults.totalWinningPrice()).isEqualTo(65000);
    }
}