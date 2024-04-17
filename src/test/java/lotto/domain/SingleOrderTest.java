package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SingleOrderTest {
    @Test
    @DisplayName("구매 생성 테스트")
    public void purchaseInitializationTest() {
        SingleOrder lottoPurchase = new SingleOrder("Lotto", 15000);

        assertThat(lottoPurchase.getProduct()).isEqualTo(Product.LOTTO);
    }

    @Test
    @DisplayName("구매 금액 음수 오류 테스트")
    public void purchasePriceNegativeError() {
        assertThatThrownBy(() -> new SingleOrder("Lotto", -1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NEGATIVE_PURCHASE_PRICE_ERROR.getMessage());
    }

    @Test
    @DisplayName("구매 금액 단위 오류 테스트")
    public void purchaseSingularPriceError() {
        assertThatThrownBy(() -> new SingleOrder("Lotto", 15400))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PURCHASE_SINGULAR_PRICE_ERROR.getMessage());

        assertThatThrownBy(() -> new SingleOrder("Lotto", 1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PURCHASE_SINGULAR_PRICE_ERROR.getMessage());

        assertThatThrownBy(() -> new SingleOrder("Lotto", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ZERO_PURCHASE_PRICE_ERROR.getMessage());
    }
}
