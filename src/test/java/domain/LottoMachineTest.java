package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    public void 가능한_개수만큼_로또를_구매한다() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchase(14000);
        assertThat(lottos).hasSize(14);
    }

    @Test(expected = IllegalStateException.class)
    public void 당첨번호가_설정되지_않았는데_순위를_얻어오면_예외가_발생한다() {
        LottoMachine lottoMachine = new LottoMachine();

        lottoMachine.createLottoResult(Arrays.asList(Lotto.manual(Arrays.asList(1,2,3,4,5,6))));
    }

    @Test
    public void 로또들의_결과를_생성한다() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.initWinningLotto(
            new WinningLotto(Arrays.asList(1,2,3,4,5,6), 7));

        LottoResult lottoResult = lottoMachine.createLottoResult(
            Arrays.asList(Lotto.manual(Arrays.asList(1,2,3,4,5,6)),
                Lotto.manual(Arrays.asList(1,2,3,4,5,6)),
                Lotto.manual(Arrays.asList(1,2,3,4,5,7))));

        assertThat(lottoResult).isNotNull();
    }
}
