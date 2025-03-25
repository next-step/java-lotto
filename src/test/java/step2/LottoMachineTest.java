package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    void 로또_머신은_돈_받은만큼_로또_생성() {
        LottoMachine lottoMachine = new LottoMachine(new LottoGenerator());
        List<Lotto> lottos = lottoMachine.buyLottos(5000);

        assertThat(lottos).hasSize(5);
    }
}
