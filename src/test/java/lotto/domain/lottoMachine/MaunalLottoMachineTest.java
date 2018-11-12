package lotto.domain.lottoMachine;

import lotto.domain.Lotto;
import lotto.domain.LottoRequest;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MaunalLottoMachineTest {
    private LottoMachine lottoMachine = null;

    @Before
    public void setup() {
        lottoMachine = new MaunalLottoMachine();
    }
    @Test
    public void 티켓_발급_검증() {
        List<Lotto> lottos = lottoMachine.createLotto(new LottoRequest(Money.of(1000), new String[]{"1,2,3,4,5,6"}));
        assertThat(lottos.size()).isEqualTo(1);
    }
}