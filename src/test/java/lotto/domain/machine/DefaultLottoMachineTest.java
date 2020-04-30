package lotto.domain.machine;

import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLottoMachineTest {
    private LottoMachine defaultLottoMachine;
    private Money money;

    @BeforeEach
    public void setup() {
        defaultLottoMachine = new DefaultLottoMachine();
        money = new Money(14_000);
    }

    @Test
    public void 자동만() {
        LottoGroup lottoGroup = defaultLottoMachine.buyLotto(money, Collections.emptyList());
        assertThat(lottoGroup.getLottos()).hasSize(14);
    }

    @Test
    public void 수동2장_자동12장() {
        LottoGroup lottoGroup = defaultLottoMachine.buyLotto(money, Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"));
        assertThat(lottoGroup.getLottos()).hasSize(14)
                .contains(Lotto.ofComma("1,2,3,4,5,6"),
                        Lotto.ofComma("7,8,9,10,11,12"));
    }
}
