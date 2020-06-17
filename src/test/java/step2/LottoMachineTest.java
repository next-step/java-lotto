package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoMachineTest {

    @DisplayName("로또를 돈으로 구입한다")
    @Test
    void buy() {
        Money money = Money.buy(14000);
        List<Lotto> lottos = LottoMachine.buy(money);
        assertThat(lottos.size()).isEqualTo(14);
    }
}
