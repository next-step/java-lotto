package lotto.domain;

import lotto.vo.LottoWinningNumber;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    private static LottoMachine lottoMachine = LottoMachine.getInstance();

    @Test
    public void 당첨번호체크() {
        Lotto lotto = new Lotto(Arrays.asList(lottoMachine.getLottoNoInstance(1), lottoMachine.getLottoNoInstance(2), lottoMachine.getLottoNoInstance(3),
                lottoMachine.getLottoNoInstance(4), lottoMachine.getLottoNoInstance(5), lottoMachine.getLottoNoInstance(6)));

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lotto, lottoMachine.getLottoNoInstance(7));
        lottoWinningNumber.checkWinningNumber(Arrays.asList(lotto), lottoMachine.getLottoNoInstance(1));
        assertThat(lotto.getMatchCount()).isEqualTo(1);
    }
}