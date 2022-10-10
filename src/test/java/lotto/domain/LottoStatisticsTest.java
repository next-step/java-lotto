package lotto.domain;

import lotto.domain.type.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.fixture.Fixture.getLottoNumbersFixture;
import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @DisplayName("구매 금액보다 당첨금이 같거나 많은 경우 수익률은 1 이상이다.")
    @Test
    void profit() {
        Lottos lottos = getLottosFixture();
        Lotto winLotto = lottos.values().get(0);

        LottoNumber bonusNumber = LottoNumber.of(45);
        LottoStatistics lottoStatistics = new LottoStatistics(lottos, new WinningLotto(winLotto, bonusNumber));

        assertThat(lottoStatistics.profit()).isGreaterThanOrEqualTo(1.0);
    }

    @DisplayName("구매 금액보다 당첨금이 적은 경우 수익률은 1 미만이다.")
    @Test
    void profitLess() {
        Lottos lottos = getLottosFixture();
        List<LottoNumber> lottoNumbersB = getLottoNumbersFixture(12, 7, 8, 9, 10, 11);
        Lotto winLotto = new ManualLotto(lottoNumbersB);
        LottoNumber bonusNumber = LottoNumber.of(45);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, new WinningLotto(winLotto, bonusNumber));

        assertThat(lottoStatistics.profit()).isLessThan(1.0);
    }

    @DisplayName("랭크 결과 집계")
    @Test
    void _1st() {
        List<LottoNumber> lottoNumbers = getLottoNumbersFixture(1, 2, 3, 4, 5, 6);

        Lotto winLotto = new ManualLotto(lottoNumbers);
        Lottos lottos = getLottosFixture();

        LottoNumber bonusNumber = LottoNumber.of(45);
        LottoStatistics lottoStatistics = new LottoStatistics(lottos, new WinningLotto(winLotto, bonusNumber));

        assertThat(lottoStatistics.getMatchCount(Rank.FIRST)).isEqualTo(1);
    }

    private Lottos getLottosFixture() {
        List<LottoNumber> lottoNumbers = getLottoNumbersFixture(1, 2, 3, 4, 5, 6);

        Lotto lotto = new ManualLotto(lottoNumbers);

        return new Lottos(List.of(lotto));
    }
}