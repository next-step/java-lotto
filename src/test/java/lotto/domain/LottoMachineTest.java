package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LottoMachineTest {

    private LottoMachine lottoMachine = null;
    
    @Before
    public void setup() {
        lottoMachine = new LottoMachine();
    }
    
    @Test
    public void 티켓_자동발급_검증() {
        Lotto lotto = lottoMachine.createLotto();
        assertThat(lotto).isNotNull();
    }

    @Test
    public void 일등로또_발급_검증() {
        WInningLotto lotto = lottoMachine.createWinningLotto("1,2,3,4,5,6", 7);
        assertThat(lotto).isNotNull();
    }
}
