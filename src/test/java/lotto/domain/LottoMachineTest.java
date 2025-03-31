package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    @DisplayName("구매 금액이 1000원 미만이면 IllegalArgumentException 발생")
    public void testPurchaseAmountBelowMinimum() {
        LottoMachine machine = new LottoMachine();
        assertThrows(IllegalArgumentException.class, () -> machine.buy(500));
    }

    @Test
    @DisplayName("구매 금액이 1000원 단위가 아니면 IllegalArgumentException 발생")
    public void testPurchaseAmountNotMultiple() {
        LottoMachine machine = new LottoMachine();
        assertThrows(IllegalArgumentException.class, () -> machine.buy(1500));
    }

}