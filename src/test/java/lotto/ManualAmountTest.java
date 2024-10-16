package lotto;

import lotto.domain.Amount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualAmountTest {
    @Test
    void calculateAutoPurchaseQuantity() {
        Amount manualAmount = new Amount(3);
        int quantity = manualAmount.calculateAutoPurchaseQuantity(5);
        assertThat(quantity).isEqualTo(2);
    }
}
