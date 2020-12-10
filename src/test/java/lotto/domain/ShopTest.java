package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    @Test
    @DisplayName("로또 구매 test")
    void purchaseLottoTest() {
        Lottos purchasedLottos = Shop.buyLottos(13_000);
        assertThat(purchasedLottos.getLottos().size()).isEqualTo(13);
    }
}
