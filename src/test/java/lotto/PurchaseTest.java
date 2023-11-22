package lotto;

import lotto.domain.Purchase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PurchaseTest {

    @DisplayName("구매 금액을 전달하면 purchase 객체를 생성한다.")
    @Test
    void purchaseCreateTest() {
        Purchase purchase = new Purchase(10000, Purchase.purchaseCount(10000));

        assertThat(purchase).isInstanceOf(Purchase.class);
    }

    @DisplayName("1000보다 적은 금액을 전달하면 IllegalArgumentException을 던진다.")
    @Test
    void purchaseCreateErrorTest() {
        assertThatThrownBy(() -> new Purchase(500, Purchase.purchaseCount(500)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액을 가져올 수 있다.")
    @Test
    void getAmountTest() {
        Purchase purchase = new Purchase(15000, Purchase.purchaseCount(15000));

        assertThat(purchase.getAmount()).isEqualTo(15000);
    }

    @DisplayName("구매 개수를 가져올 수 있다.")
    @Test
    void getCount() {
        Purchase purchase = new Purchase(7000, Purchase.purchaseCount(7000));

        assertThat(purchase.getCount()).isEqualTo(7);
    }
}
