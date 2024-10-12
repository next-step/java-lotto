package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    void 로또_구매_테스트() {
        PurchasePrice purchasePrice = new PurchasePrice(14000);
        Lottos lottos = new Lottos(purchasePrice);
        assertThat(lottos.getLottos().size()).isEqualTo(14);
    }

}