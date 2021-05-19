package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoShopTest {

    @Test
    @DisplayName("로또 구입금액 입력시 해당 금액만큼 로또 구매")
    void buyLottos() {
        long price = 14000L;
        LottoShop lottoShop = new LottoShop();

        List<Lotto> lottos = lottoShop.buyLottos(price);

        Assertions.assertThat(lottos).hasSize(14);
    }
}
