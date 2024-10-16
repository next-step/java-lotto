package lotto;

import lotto.domain.Amount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashAmountTest {

    @Test
    void isLessThan() {
        Amount cashAmount = new Amount(1000);
        boolean isLess = cashAmount.isLessThan(2000);
        assertThat(isLess).isTrue();
    }

    @Test
    void calculatePurchaseQuantity() {
        Amount cashAmount = new Amount(3000);
        int purchaseQuantity = cashAmount.calculatePurchaseQuantity(1000);
        assertThat(purchaseQuantity).isEqualTo(3);
    }

    @Test
    void calculateProfitRate() {
        Amount cashAmount = new Amount(4000);
        double profitRate = cashAmount.calculateProfitRate(2000);
        assertThat(profitRate).isEqualTo(0.5);
    }
}
