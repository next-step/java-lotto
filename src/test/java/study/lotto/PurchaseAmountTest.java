package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {

    @Test
    @DisplayName("1000원 미만 구매 실패")
    void test_create_fail() {
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(500, 0));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "1500,1", "2000,2"})
    void test_purchase_count(int amount, int numberOfPurchases) {
        // When
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount, 0);

        // Then
        assertEquals(purchaseAmount.numberOfPurchases(), numberOfPurchases);
    }
}