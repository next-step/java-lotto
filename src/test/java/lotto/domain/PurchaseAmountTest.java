package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    private PurchaseAmount purchaseAmount = PurchaseAmount.newInstance(3000);

    @DisplayName("구입금액이 1000원 미만이면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = { 100, 200, 500, 900, 999 })
    void canNotCreatePurchaseAmountIfAmountLessThen1000(int amount) {
        assertThatThrownBy(() -> PurchaseAmount.newInstance(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000원 이상이면 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = { 1000, 1200, 2000, 2500, 3000 })
    void canCreatePurchaseAmountIfAmount1000OrMore(int amount) {
        assertThat(PurchaseAmount.newInstance(amount)).isInstanceOf(PurchaseAmount.class);
    }

    @DisplayName("구입금액을 얻을 수 있다.")
    @Test
    void canGetPurchaseAmount() {
        assertThat(this.purchaseAmount.getPurchaseAmount()).isEqualTo(3000);
    }

    @DisplayName("총 구입수량을 얻을 수 있다.")
    @Test
    void canCalculatePurchaseCount() {
        assertThat(this.purchaseAmount.calculatePurchaseCount()).isEqualTo(3);
    }

    @DisplayName("구입금액이 같으면 동일한 객체이다.")
    @Test
    void canSamePurchaseAmountIfAmountSame() {
        PurchaseAmount purchaseAmount2 = PurchaseAmount.newInstance(this.purchaseAmount.getPurchaseAmount());

        assertThat(this.purchaseAmount.getPurchaseAmount()).isEqualTo(purchaseAmount2.getPurchaseAmount());
        assertThat(this.purchaseAmount).isEqualTo(purchaseAmount2);
        assertThat(this.purchaseAmount.hashCode()).isEqualTo(purchaseAmount2.hashCode());
    }

}
