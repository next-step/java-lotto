package raffle.lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    LottoMachine lottoMachine;

    @Before
    public void setUp(){
        lottoMachine = new LottoMachine(13000);
    }

    @Test
    public void 로또입력확인() {
        assertThat(lottoMachine.getLottos()).hasSize(13);
    }

}