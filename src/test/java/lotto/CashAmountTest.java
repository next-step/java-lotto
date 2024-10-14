package lotto;

import lotto.domain.CashAmount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashAmountTest {

    @Test
    void isLessThan() {
        CashAmount cashAmount = new CashAmount(1000);
        boolean isLess = cashAmount.isLessThan(2000);
        assertThat(isLess).isTrue();
    }

    @Test
    void calculatePurchaseQuantity() {
        CashAmount cashAmount = new CashAmount(3000);
        int purchaseQuantity = cashAmount.calculatePurchaseQuantity(1000);
        assertThat(purchaseQuantity).isEqualTo(3);
    }

    @Test
    void calculateProfitRate() {
        CashAmount cashAmount = new CashAmount(4000);
        double profitRate = cashAmount.calculateProfitRate(2000);
        assertThat(profitRate).isEqualTo(0.5);
    }
}
