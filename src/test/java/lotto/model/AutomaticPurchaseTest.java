package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.model.LottoMachine.EMPTY;
import static org.assertj.core.api.Assertions.assertThat;

class AutomaticPurchaseTest {

    @Test
    void 자동구매는_수량만큼_로또생성하여_반환한다() {
        LottoMachine machine = new AutomaticPurchase();
        List<Lotto> lottos = machine.purchase(2, EMPTY);

        assertThat(lottos).hasSize(2);
    }
}
