package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @Test
    @DisplayName("일치개수확인/MyLotto와WinningLotto를 넣는다/일치개수별 로또의 개수가 나온다.")
    void statisticsMatchCount() {
        // given
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        MyLottos myLottos = new MyLottos(Arrays.asList(lotto1, lotto2));

        // when
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.check(myLottos, winningLotto);

        // then
        assertThat(lottoStatistics.getMatchCount(6)).isEqualTo(1);
        assertThat(lottoStatistics.getMatchCount(5)).isEqualTo(0);
        assertThat(lottoStatistics.getMatchCount(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("수령금확인/당첨개수확인되어있음/총 수령금")
    void getReceiveMoney() {
        // given
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        MyLottos myLottos = new MyLottos(Arrays.asList(lotto1, lotto2));

        // when
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.check(myLottos, winningLotto);

        // then
        assertThat(lottoStatistics.getReceiveMoney())
                .isEqualTo(ReceiveMoney.MATCH_4_RECEIVE_MONEY.getMoney() + ReceiveMoney.MATCH_6_RECEIVE_MONEY.getMoney());
    }
}