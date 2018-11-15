package lotto.domain.lottoMachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import lotto.domain.LottoMachine;
import lotto.domain.LottoRequest;
import lotto.domain.LottoTicket;
import lotto.domain.Money;

public class DefaultLottoMachineTest {

    private LottoMachine lottoMachine = null;
    
    @Before
    public void setup() {
        lottoMachine = new DefaultLottoMachine(new AutoLottoMachine(), new ManualLottoMachine());
    }
    
    @Test
    public void 티켓_자동발급_검증() {
        LottoTicket lottos = lottoMachine.createLotto(new LottoRequest(Money.of(2000)));
        assertThat(lottos.getCount()).isEqualTo(2);
    }

    @Test
    public void 티켓_수동발급_검증() {
        LottoTicket lottos = lottoMachine.createLotto(new LottoRequest(Money.of(1000), new String[]{"1,2,3,4,5,6"}));
        assertThat(lottos.getCount()).isEqualTo(1);
    }

}
