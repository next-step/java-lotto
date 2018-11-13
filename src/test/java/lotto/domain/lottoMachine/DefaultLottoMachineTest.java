package lotto.domain.lottoMachine;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.domain.LottoRequest;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DefaultLottoMachineTest {

    private LottoMachine lottoMachine = null;
    
    @Before
    public void setup() {
        lottoMachine = new DefaultLottoMachine();
    }
    
    @Test
    public void 티켓_자동발급_검증() {
        List<Lotto> lottos = lottoMachine.createAutoLotto(new LottoRequest(Money.of(2000)));
        assertThat(lottos.size()).isEqualTo(2);
    }

    @Test
    public void 티켓_수동발급_검증() {
        List<Lotto> lottos = lottoMachine.createManualLotto(new LottoRequest(Money.of(1000), new String[]{"1,2,3,4,5,6"}));
        assertThat(lottos.size()).isEqualTo(1);
    }

}
