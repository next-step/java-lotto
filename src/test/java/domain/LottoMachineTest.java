package domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    public void 구입_금액에_맞는_갯수의_로또를_반환한다() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> games = lottoMachine.purchaseLotto(new Money(14500));

        assertThat(games).hasSize(14);
    }

}