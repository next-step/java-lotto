package lotto.domain;

import lotto.generator.ManualNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultsTest {

    @Test
    public void 당첨번호_통계() {
        LottoGame lottoGame = LottoUtils.createLottoGame();
        Lotto winning = new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 6"));
        LottoNumber bonus = LottoNumber.from(10);
        LottoResults lottoResults = new LottoResults();

        lottoResults.getTotalResults(lottoGame, winning, bonus);

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
        Lotto winning = new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 6"));
        LottoNumber bonus = LottoNumber.from(10);
        LottoResults lottoResults = new LottoResults();
        lottoResults.getTotalResults(lottoGame, winning, bonus);

        assertThat(lottoResults.getProfitRate(lottoGame.getManualCount() + lottoGame.getAutoCount())).isEqualTo(0.7);
    }

}