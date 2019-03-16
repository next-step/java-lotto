package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    public void 당첨번호체크() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoMachine.checkWinningNumber(Arrays.asList(lotto), 1);
        assertThat(lotto.getMatchCount()).isEqualTo(1);
    }

    @Test
    public void 통계_DTO_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), 3);
        LottoStatistics lottoStatistics = LottoMachine.checkWinningLotto(Arrays.asList(lotto));
        assertThat(lottoStatistics.getForthCnt()).isEqualTo(1);
        assertThat(lottoStatistics.getProfit()).isEqualTo(5.0);
    }

}