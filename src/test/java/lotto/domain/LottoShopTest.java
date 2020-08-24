package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoShopTest {

    private LottoShop lottoShop;

    @BeforeEach
    void init() {
        lottoShop = LottoShop.getInstance();
    }

    @Test
    @DisplayName("구매 금액에 따라 정확한 개수 구매 테스트")
    void buy_lotto() {
        int money = 14000;
        int manualLottoCount = 0;
        assertThat(lottoShop.buyLotto(money, manualLottoCount).getPublishedLottoTicket()).hasSize(money / 1000);
    }

    @Test
    @DisplayName("구매 금액 0 또는 음수 테스트")
    void zero_or_negative_price() {
        assertThatThrownBy(() -> lottoShop.buyLotto(0, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoShop.buyLotto(-1000, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 금액이 천원 단위가 아닌 경우 테스트")
    void price_not_divided_1000() {
        assertThatThrownBy(() -> lottoShop.buyLotto(500, 0)).isInstanceOf(IllegalArgumentException.class);
    }
}
