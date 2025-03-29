package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @Test
    @DisplayName("구매 금액이 음수이면 에러가 발생한다.")
    void validatePurchaseAmount() {
        assertThatThrownBy(() -> new PurchaseAmount(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("상품 금액을 입력하면 구매할 수 있는 수량을 반환한다.")
    void getTicketCount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);
        assertThat(purchaseAmount.getTicketCount(1000)).isEqualTo(1);
    }

    @Test
    @DisplayName("구매 금액이 상품 금액으로 나누어 떨어지지 않으면 에러가 발생한다.")
    void validateDividedAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1001);
        assertThatThrownBy(() -> purchaseAmount.getTicketCount(1000)).isInstanceOf(IllegalArgumentException.class);
    }


}