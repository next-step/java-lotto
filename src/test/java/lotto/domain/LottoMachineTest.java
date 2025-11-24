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

    @Test
    void 로또번호_수동_생성() {
        BuyLotto buyLotto = new BuyLotto();
        buyLotto.add(new Lotto(1, 2, 3, 4, 5, 6));
        LottoMachine.createLotto(buyLotto, new LottoPrice(5000, 1));
        assertThat(buyLotto.getLottos()).hasSize(5);
    }
}
