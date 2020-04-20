package lotto.domain.machine;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLottoMachineTest {
    private LottoMachine defaultLottoMachine;
    private Money money;

    @BeforeEach
    public void setup() {
        List<String> manualLottoNumbers = Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12");
        defaultLottoMachine = new DefaultLottoMachine(manualLottoNumbers);
        money = new Money(14_000);
    }

    @Test
    public void buyLotto() {
        List<Lotto> lottos = defaultLottoMachine.buyLotto(money);
        assertThat(lottos).hasSize(14)
                .contains(Lotto.ofComma("1,2,3,4,5,6"),
                        Lotto.ofComma("7,8,9,10,11,12"));
    }
}
