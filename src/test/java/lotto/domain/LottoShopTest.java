package lotto.domain;

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
        LottoMoney lottoMoney = new LottoMoney(money);

        // when & then
        assertThat(lottoShop.buyLotto(lottoMoney).getPublishedLottoTicket()).hasSize(money / 1000);
    }

    @Test
    @DisplayName("구매 금액 0 또는 음수 테스트")
    void zero_or_negative_money_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            lottoShop.buyLotto(new LottoMoney(0));
            lottoShop.buyLotto(new LottoMoney(-1000));
        }).withMessageMatching("금액이 부족합니다. 로또를 구매할 수 없습니다.");
    }

    @Test
    @DisplayName("구매 금액이 천원 단위가 아닌 경우 테스트")
    void not_divided_by_1000_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            lottoShop.buyLotto(new LottoMoney(500));
        }).withMessageMatching("금액이 부족합니다. 로또를 구매할 수 없습니다.");
    }

}
