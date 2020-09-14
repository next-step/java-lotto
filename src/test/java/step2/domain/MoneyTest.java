package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("최소 금액 체크")
    void of() {
        assertThrows(IllegalArgumentException.class, () -> Money.of(900));
    }

    @Test
    @DisplayName("로또 구매 갯수 체크")
    void getNumberOfPurchases() {
        assertEquals(Money.of(1000).getNumberOfPurchases(1000), 1);
        assertEquals(Money.of(1250).getNumberOfPurchases(1000), 1);
        assertEquals(Money.of(12500).getNumberOfPurchases(1000), 12);
    }

    @Test
    void totalYield() {
        Money money = Money.of(14500);
        money.getNumberOfPurchases(1000);
        assertEquals(money.totalYield(5000), 0.36);
    }
}