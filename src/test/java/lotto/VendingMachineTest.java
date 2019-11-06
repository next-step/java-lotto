package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Test
    void buy_lotto() {
        vendingMachine = new VendingMachine(10000);
        assertThat(vendingMachine.buy().getCount()).isEqualTo(10);
    }
}
