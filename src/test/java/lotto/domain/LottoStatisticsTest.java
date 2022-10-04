package lotto.domain;

import lotto.domain.type.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @DisplayName("구매 금액보다 당첨금이 같거나 많은 경우 수익률은 1 이상이다.")
    @Test
    void profit() {
        Lottos lottos = getLottosFixture();
        Lotto winLotto = lottos.values().get(0);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winLotto);

        assertThat(lottoStatistics.profit()).isGreaterThanOrEqualTo(1.0);
    }

    @DisplayName("구매 금액보다 당첨금이 적은 경우 수익률은 1 미만이다.")
    @Test
    void profitLess() {
        Lottos lottos = getLottosFixture();
        List<LottoNumber> lottoNumbersB = List.of(new LottoNumber(12),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9),
                new LottoNumber(10),
                new LottoNumber(11));
        Lotto winLotto = new Lotto(lottoNumbersB);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winLotto);

        assertThat(lottoStatistics.profit()).isLessThan(1.0);
    }

    @DisplayName("랭크 결과 집계")
    @Test
    void _1st() {
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));

        Lotto winLotto = new Lotto(lottoNumbers);
        Lottos lottos = getLottosFixture();

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winLotto);

        assertThat(lottoStatistics.getMatchCount(Rank.FIRST)).isEqualTo(1);
    }

    private Lottos getLottosFixture() {
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumbers);

        return new Lottos(List.of(lotto));
    }
}