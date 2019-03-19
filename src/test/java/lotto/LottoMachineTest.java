package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.vo.LottoNo;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    public void 당첨번호체크() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoMachine.checkWinningNumber(Arrays.asList(lotto), new LottoNo(1));
        assertThat(lotto.getMatchCount()).isEqualTo(1);
    }
}