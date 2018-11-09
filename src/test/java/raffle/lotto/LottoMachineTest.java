package raffle.lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    public void 로또입력확인() {
        LottoMachine lottoMachine = new LottoMachine(13000);
        assertThat(lottoMachine.getLottos()).hasSize(13);
    }

    @Test
    public void 로또_보너스볼_확인() {
        List<Integer> number = Arrays.asList(1, 6 , 5 , 44 , 22 , 15);
        Lotto lotto = new Lotto(number);

        LottoMachine lottoMachine = new LottoMachine(13000);



        assertThat(lottoMachine.getLottos()).hasSize(13);
    }

}