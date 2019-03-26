package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    private LottoMachine lottoMachine = new LottoMachine();

    @Test
    public void 로또_용지를_통해_로또를_구매한다() {
        List<Lotto> lottos = lottoMachine.purchase(new LottoPaper(new LottoMoney(15000)));
        assertThat(lottos).hasSize(15);
    }

    @Test(expected = IllegalStateException.class)
    public void 당첨번호가_설정되지_않았는데_순위를_얻어오면_예외가_발생한다() {
        lottoMachine.createLottoResult(Arrays.asList(Lotto.create(NumberSet.fill(1,2,3,4,5,6))));
    }

    @Test
    public void 로또들의_결과를_생성한다() {
        lottoMachine.initWinningLotto(
            new WinningLotto(NumberSet.fill(1,2,3,4,5,6), 7));

        LottoResult lottoResult = lottoMachine.createLottoResult(
            Arrays.asList(Lotto.create(NumberSet.fill(1,2,3,4,5,6)),
                Lotto.create(NumberSet.fill(1,2,3,4,5,6)),
                Lotto.create(NumberSet.fill(1,2,3,4,5,7))));

        assertThat(lottoResult).isNotNull();
    }
}
