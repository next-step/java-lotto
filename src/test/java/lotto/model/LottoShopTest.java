package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopTest {
    @Test
    @DisplayName("로또 가게는 싱글톤이다")
    void getInstance() throws Exception {
        LottoShop lottoShop = LottoShop.getInstance();
        Assertions.assertThat(lottoShop).isInstanceOf(LottoShop.class);
    }

    @Test
    @DisplayName("금액을 받으면 금액만큼 로또를 줘야한다")
    void buy() throws Exception {
        LottoShop lottoShop = LottoShop.getInstance();
        Lottos lottos = lottoShop.buy(15_000);
        Assertions.assertThat(lottos).isInstanceOf(Lottos.class);
    }

    @Test
    @DisplayName("금액이 LOTTO_PRICE 미만이면 예외를 던진다")
    void buyFalse() throws Exception {
        LottoShop lottoShop = LottoShop.getInstance();
        Assertions.assertThatThrownBy(() -> lottoShop.buy(999))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("don't have enough money.");
    }
}
