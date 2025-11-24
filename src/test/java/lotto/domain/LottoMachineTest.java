package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @Test
    void 로또번호_생성() {
        BuyLotto buyLotto = new BuyLotto();
        LottoMachine.createLotto(buyLotto, new LottoPrice(5000));
        assertThat(buyLotto.getLottos()).hasSize(5);
    }
}
