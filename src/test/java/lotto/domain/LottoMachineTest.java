package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @Test
    void 로또번호_생성() {

        PurchasedLottos purchasedLottos = LottoMachine.createLotto(new LottoPrice(5000, 0));
        assertThat(purchasedLottos.getLottos()).hasSize(5);
    }

    @Test
    void 로또번호_수동_생성() {
        PurchasedLottos purchasedLottos = LottoMachine.createLotto(new LottoPrice(5000, 1));
        purchasedLottos.addAll(new PurchasedLottos(List.of(new Lotto(1, 2, 3, 4, 5, 6))));
        assertThat(purchasedLottos.getLottos()).hasSize(5);
    }
}
