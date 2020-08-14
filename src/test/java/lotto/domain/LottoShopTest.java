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
        exceptIllegalArgumentException(() -> LottoShop.purchasePrice(0));
        exceptIllegalArgumentException(() -> LottoShop.purchasePrice(-1000));
    }

    @Test
    @DisplayName("구입금액 천원 단위가 아닐 경우")
    void buy_notDivided1000_exceptThrown() {
        exceptIllegalArgumentException(() -> LottoShop.purchasePrice(150));
    }

    @Test
    @DisplayName("구입금액에 따라 정확한 개수 구매")
    void buy() {
        int price = 14000;
        assertThat(LottoShop.purchasePrice(14000)
                .buyAuto()
                .getLottos()
        ).hasSize(price / DEFAULT_PRICE_UNIT);
    }

    @Test
    @DisplayName("구입금액 이상 수동 구매 시 예외 발생")
    void buy_overMoney_exceptThrown() {
        exceptIllegalArgumentException(
                () -> LottoShop.purchasePrice(1000)
                        .buyManual(5, Lotto::generateAuto)
        );
    }

    @Test
    @DisplayName("구입금액에 따라 구매한 수동, 자동 개수 일치")
    void buy_autoAndManual_return() {
        // given
        int price = 14000;
        int manualCount = 5;

        // when
        LottoShop lottoShop = LottoShop.purchasePrice(14000)
                .buyManual(manualCount, Lotto::generateAuto)
                .buyAuto();

        assertThat(lottoShop.getAutoCount()).isEqualTo((price / DEFAULT_PRICE_UNIT) - manualCount);
        assertThat(lottoShop.getManualCount()).isEqualTo(manualCount);
    }

    private void exceptIllegalArgumentException(ThrowableAssert.ThrowingCallable throwingCallable) {
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }
}
