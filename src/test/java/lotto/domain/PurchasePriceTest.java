package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchasePriceTest {

    private PurchasePrice purchasePrice = PurchasePrice.newInstance(3000);

    @DisplayName("구입금액이 1000원 미만이면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = { 100, 200, 500, 900, 999 })
    void canNotCreatePurchasePriceIfPriceLessThen1000(int amount) {
        assertThatThrownBy(() -> PurchasePrice.newInstance(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000원 이상이면 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = { 1000, 1200, 2000, 2500, 3000 })
    void canCreatePurchasePriceIfPrice1000OrMore(int amount) {
        assertThat(PurchasePrice.newInstance(amount)).isInstanceOf(PurchasePrice.class);
    }

    @DisplayName("구입금액을 얻을 수 있다.")
    @Test
    void canGetPurchasePrice() {
        assertThat(this.purchasePrice.getPurchasePrice()).isEqualTo(3000);
    }

    @DisplayName("총 구입수량을 얻을 수 있다.")
    @Test
    void canCalculatePurchaseCount() {
        assertThat(this.purchasePrice.calculatePurchaseCount()).isEqualTo(3);
    }

    @DisplayName("구입금액이 같으면 동일한 객체이다.")
    @Test
    void canSamePurchasePriceIfPriceSame() {
        PurchasePrice purchasePrice2 = PurchasePrice.newInstance(this.purchasePrice.getPurchasePrice());

        assertThat(this.purchasePrice.getPurchasePrice()).isEqualTo(purchasePrice2.getPurchasePrice());
        assertThat(this.purchasePrice).isEqualTo(purchasePrice2);
        assertThat(this.purchasePrice.hashCode()).isEqualTo(purchasePrice2.hashCode());
    }
}
