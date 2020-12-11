package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    @Test
    @DisplayName("로또 구매 test")
    void purchaseLottoTest() {
        List<Lotto> purchasedLottos = Shop.buyLottos(13000L);
        assertThat(purchasedLottos.size()).isEqualTo(13);
    }
}
