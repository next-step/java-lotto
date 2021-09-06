package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("가능한 로또 등수가 모두 저장되었는지 테스트")
    void lottoRanksInResult() {
        LottoResult lottoResult = new LottoResult(0);
        for (LottoRank rank : LottoRank.ranks()) {
            assertThat(lottoResult.winningCount(rank)).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("당첨된 로또 등수 카운트가 잘 되는지 테스트")
    void record() {
        LottoResult lottoResult = new LottoResult(0);

        lottoResult.record(LottoRank.NONE);
        assertThat(lottoResult.winningCount(LottoRank.NONE)).isEqualTo(0);

        lottoResult.record(LottoRank.THIRD);
        assertThat(lottoResult.winningCount(LottoRank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 금액에 따른 수익률 계산 테스트")
    void profitRate() {
        LottoResult lottoResult = new LottoResult(1000);
        lottoResult.record(LottoRank.FIFTH);
        assertThat(lottoResult.profitRate()).isEqualTo(5);

        LottoResult lottoResultZero = new LottoResult(0);
        lottoResult.record(LottoRank.FIFTH);
        assertThat(lottoResultZero.profitRate()).isEqualTo(0);
    }
}