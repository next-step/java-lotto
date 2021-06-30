package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseCalculatorTest {

    @DisplayName("금액 입력시 입력된 금액으로 구매 가능한 로또의 갯수가 반환된다.")
    @Test
    void countPurchasableTest() {
        int purchaseAmount = 14000;
        PurchaseCalculator purchaseCalculator = new PurchaseCalculator(purchaseAmount);
        assertThat(purchaseCalculator.getPurchasableLottoCounts()).isEqualTo(14);
    }
}
