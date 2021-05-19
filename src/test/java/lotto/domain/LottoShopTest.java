package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShopTest {

    @Test
    @DisplayName("로또 구입금액 입력시 해당 금액만큼 로또 구매")
    void buyLottos() {
        long price = 14000L;
        LottoShop lottoShop = new LottoShop();

        Lottos lottos = lottoShop.buyLottos(price);

        assertThat(lottos.getValues()).hasSize(14);
    }
}
