package lotto.domain.lottoMachine;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.domain.LottoRequest;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AutoLottoMachineTest {

    private LottoMachine lottoMachine = null;
    
    @Before
    public void setup() {
        lottoMachine = new AutoLottoMachine();
    }
    
    @Test
    public void 티켓_자동발급_검증() {
        List<Lotto> lottos = lottoMachine.createLotto(new LottoRequest(Money.of(1000)));
        assertThat(lottos.size()).isEqualTo(1);
    }

}
