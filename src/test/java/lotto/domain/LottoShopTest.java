package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoShopTest {

    @Test
    @DisplayName("구매 금액에 따라 정확한 개수 구매 테스트")
    void buy_lotto() {
        int price = 14000;
        assertThat(LottoShop.buyLotto(price).getPublishedLottoTicket()).hasSize(price / 1000);
    }

    @Test
    @DisplayName("구매 금액 0 또는 음수 테스트")
    void zero_or_negative_price() {
        assertThatThrownBy(() -> LottoShop.buyLotto(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoShop.buyLotto(-1000)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 금액이 천원 단위가 아닌 경우 테스트")
    void price_not_divided_1000() {
        assertThatThrownBy(() -> LottoShop.buyLotto(500)).isInstanceOf(IllegalArgumentException.class);
    }
}
