package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoMachineTest {

    @Test
    void buy() {
        Money money = Money.buy(14000);
        List<Lotto> lottos = LottoMachine.buy(money);
        assertThat(lottos.size()).isEqualTo(14);
    }
}
