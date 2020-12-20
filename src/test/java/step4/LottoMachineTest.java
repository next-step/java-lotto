package step4;

import org.junit.jupiter.api.Test;
import step4.domain.LottoMachine;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    public void 구매갯수계산() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine.buyLotto(14000).size()).isEqualTo(14);
    }
}
