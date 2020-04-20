package lotto.domain.machine;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoMachineTest {
    private LottoMachine autoLottoMachine;
    private Money money;

    @BeforeEach
    public void setup() {
        autoLottoMachine = new AutoLottoMachine();
        money = new Money(14_000);
    }

    @Test
    public void buyLotto() {
        List<Lotto> lottos = autoLottoMachine.buyLotto(money);
        assertThat(lottos).hasSize(14);
    }
}
