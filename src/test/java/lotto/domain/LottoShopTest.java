package lotto.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoShop.DEFAULT_PRICE_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoShopTest {

    @Test
    @DisplayName("구입금액 0 또는 음수")
    void buy_negativePrice_exceptThrown() {
        exceptIllegalArgumentException(() -> LottoShop.purchase(0, 0));
        exceptIllegalArgumentException(() -> LottoShop.purchase(-1000, 0));
    }

    @Test
    @DisplayName("구입금액 천원 단위가 아닐 경우")
    void buy_notDivided1000_exceptThrown() {
        exceptIllegalArgumentException(() -> LottoShop.purchase(150, 0));
    }

    @Test
    @DisplayName("구입금액에 따라 정확한 개수 구매")
    void buy() {
        // given
        int price = 14000;

        // when
        Lottos lottos = LottoShop.purchase(price, 0);
        lottos.fillAuto();

        // then
        assertThat(lottos).hasSize(LottoShop.canPurchaseCount(price));
    }

    @Test
    @DisplayName("구입금액 이상 수동 구매 시 예외 발생")
    void buy_overMoney_exceptThrown() {
        exceptIllegalArgumentException(() -> LottoShop.purchase(1000, 10));
    }

    @Test
    @DisplayName("구입금액에 따라 구매 가능한 개수")
    void canPurchaseCount() {
        int price = 14000;
        assertThat(LottoShop.canPurchaseCount(price)).isEqualTo(price / DEFAULT_PRICE_UNIT);
    }

    private void exceptIllegalArgumentException(ThrowableAssert.ThrowingCallable throwingCallable) {
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }
}
