package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    public void 당첨번호체크() {
        Lotto lotto = new Lotto(Arrays.asList(LottoMachine.getLottoNoInstance(1), LottoMachine.getLottoNoInstance(2), LottoMachine.getLottoNoInstance(3),
                LottoMachine.getLottoNoInstance(4), LottoMachine.getLottoNoInstance(5), LottoMachine.getLottoNoInstance(6)));
        LottoMachine.checkWinningNumber(Arrays.asList(lotto), LottoMachine.getLottoNoInstance(1));
        assertThat(lotto.getMatchCount()).isEqualTo(1);
    }
}