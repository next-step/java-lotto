package raffle.lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    public void 로또입력확인() {
        LottoMachine lottoMachine = new LottoMachine(13000);
        assertThat(lottoMachine.getLottos().size()).isEqualTo(13);
    }

}