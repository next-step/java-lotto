package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseTest {
    @Test
    @DisplayName("구매 생성 테스트")
    public void purchaseInitializationTest() {
        Purchase lottoPurchase = new Purchase("Lotto", 15000);

        assertThat(lottoPurchase.getProduct()).isEqualTo(Product.LOTTO);
    }

    @Test
    @DisplayName("구매 금액 음수 오류 테스트")
    public void purchasePriceNegativeError() {
        assertThatThrownBy(() -> new Purchase("Lotto", -1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NEGATIVE_PURCHASE_PRICE_ERROR);
    }

    @Test
    @DisplayName("구매 금액 단위 오류 테스트")
    public void purchaseSingularPriceError() {
        Purchase lottoPurchase = new Purchase("Lotto", 15400);

        assertThatThrownBy(lottoPurchase::getPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PURCHASE_SINGULAR_PRICE_ERROR);
    }
}
