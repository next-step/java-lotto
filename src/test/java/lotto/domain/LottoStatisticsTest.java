package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        lottoStatistics = new LottoStatistics();
    }

    @Test
    @DisplayName("수익률 통계")
    void rateOfReturn() {
        assertThat(lottoStatistics.rateOfReturn(5000,14000)).isEqualTo(0.35);
    }

    @Test
    @DisplayName("로또 번호 당첨 확인 및 결과")
    void confirmOfLottoNumber() {
        // given
        Lottos lottos = new Lottos(asList(
                new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))),
                new Lotto(asList(LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9), LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12))),
                new Lotto(asList(LottoNumber.of(13), LottoNumber.of(14), LottoNumber.of(15), LottoNumber.of(16), LottoNumber.of(17), LottoNumber.of(18))),
                new Lotto(asList(LottoNumber.of(19), LottoNumber.of(20), LottoNumber.of(21), LottoNumber.of(22), LottoNumber.of(23), LottoNumber.of(24)))
        ));
        LottoWinnerNumber randomNumber = new LottoWinnerNumber("1,2,3,4,5,6",7);

        // when
        lottoStatistics.confirmOfLottoNumber(lottos,randomNumber);

        // then
        assertThat(lottoStatistics.getMatchResult().get(WinnerAmount.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등 당첨 결과 확인")
    void secondPlace() {
        // given
        Lottos lottos = new Lottos(asList(
                new Lotto(asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(7))),
                new Lotto(asList(LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9), LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12))),
                new Lotto(asList(LottoNumber.of(13), LottoNumber.of(14), LottoNumber.of(15), LottoNumber.of(16), LottoNumber.of(17), LottoNumber.of(18))),
                new Lotto(asList(LottoNumber.of(19), LottoNumber.of(20), LottoNumber.of(21), LottoNumber.of(22), LottoNumber.of(23), LottoNumber.of(24)))
        ));
        LottoWinnerNumber randomNumber = new LottoWinnerNumber("1,2,3,4,5,6",7);

        // when
        lottoStatistics.confirmOfLottoNumber(lottos,randomNumber);

        // then
        assertThat(lottoStatistics.getMatchResult().get(WinnerAmount.SECOND)).isEqualTo(1);
    }
}