package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoVendingMachineTest {

    @DisplayName("주어진 금액에 맞게 구매한다")
    @Test
    void buy() {
        int amount = 15000;

        Assertions.assertThat(LottoVendingMachine.buy(amount)).hasSize(15);
    }
}
