package lotto.domain;

import lotto.generator.ManualNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultsTest {

    @Test
    public void 당첨번호_통계() {
        LottoGame lottoGame = LottoUtils.createLottoGame();
        LottoResults lottoResults = new LottoResults();
        lottoResults.getTotalResults(lottoGame);

        assertThat(lottoResults.getRankCount(Rank.MISS)).isEqualTo(3);
        assertThat(lottoResults.getRankCount(Rank.FIFTH)).isEqualTo(2);
        assertThat(lottoResults.getRankCount(Rank.FOURTH)).isEqualTo(2);
        assertThat(lottoResults.getRankCount(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoResults.getRankCount(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResults.getRankCount(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    public void 수익률_구하기() {
        LottoGame lottoGame = LottoUtils.createLottoGame();
        LottoResults lottoResults = new LottoResults();
        lottoResults.getTotalResults(lottoGame);

        assertThat(lottoResults.getProfitRate(lottoGame.getManualLottos().lottosSize() + lottoGame.getAutoCount())).isEqualTo(0.7);
    }

}