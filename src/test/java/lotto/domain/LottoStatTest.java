package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatTest {

    @Test
    @DisplayName("일치개수확인/MyLotto와WinningLotto를 넣는다/일치개수별 로또의 개수가 나온다.")
    void statisticsMatchCount() {
        // given
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        MyLottos myLottos = new MyLottos(Arrays.asList(lotto1, lotto2));

        // when
        LottoStat lottoStat = new LottoStat();
        lottoStat.check(myLottos, winningLotto);

        // then
        assertThat(lottoStat.getMatchCountResult(6)).isEqualTo(1);
        assertThat(lottoStat.getMatchCountResult(5)).isEqualTo(0);
        assertThat(lottoStat.getMatchCountResult(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률확인/당첨개수결과와 구매금액/수익률")
    void getProfitRate() {
        // given
        Money money = new Money(2000);
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        MyLottos myLottos = new MyLottos(Arrays.asList(lotto1, lotto2));

        // when
        LottoStat lottoStat = new LottoStat();
        lottoStat.check(myLottos, winningLotto);

        // then
        System.out.println("lottoStat.getProfitRate(money) = " + lottoStat.getProfitRate(money));
        assertThat(lottoStat.getProfitRate(money))
                .isEqualTo((float) (ReceiveMoney.MATCH_4_RECEIVE_MONEY.getMoney() + ReceiveMoney.MATCH_6_RECEIVE_MONEY.getMoney()) / money.getMoney());
    }
}