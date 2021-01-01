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
        LottoList lottoList = new LottoList(asList(
                new Lotto(asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6))),
                new Lotto(asList(new Number(7), new Number(8), new Number(9), new Number(10), new Number(11), new Number(12))),
                new Lotto(asList(new Number(13), new Number(14), new Number(15), new Number(16), new Number(17), new Number(18))),
                new Lotto(asList(new Number(19), new Number(20), new Number(21), new Number(22), new Number(23), new Number(24)))
        ));
        LottoWinnerNumber randomNumber = new LottoWinnerNumber(asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)));

        // when
        lottoStatistics.confirmOfLottoNumber(lottoList,randomNumber);

        // then
        assertThat(lottoStatistics.getMatchResult().get(WinnerAmount.FIRST)).isEqualTo(1);

    }
}