package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoShopTest {

    private LottoShop lottoShop;

    @BeforeEach
    void init() {
        lottoShop = LottoShop.getInstance();
    }

    @Test
    @DisplayName("구매 금액에 따라 정확한 개수 구매 테스트")
    void buy_lotto_test() {
        // given
        int money = 14000;

        // when & then
        assertThat(lottoShop.buyLotto(money).getPublishedLottoTicket()).hasSize(money / 1000);
    }

    @Test
    @DisplayName("구매 금액 0 또는 음수 테스트")
    void zero_or_negative_money_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            lottoShop.buyLotto(0);
            lottoShop.buyLotto(-1000);
        }).withMessageMatching("금액은 최소 0이상 이어야 구매 가능합니다.");
    }

    @Test
    @DisplayName("구매 금액이 천원 단위가 아닌 경우 테스트")
    void not_divided_by_1000_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            lottoShop.buyLotto(500);
        }).withMessageMatching("지불한 금액이 1000원으로 나누어지지 않습니다.");
    }

}
