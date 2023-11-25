package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @Test
    void divideByPurchaseAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);
        assertThat(purchaseAmount.divideByPurchaseAmount(10000)).isEqualTo(2.00);
    }
}
