package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoVendingMachineTest {

    @DisplayName("주어진 금액에 맞게 구매한다")
    @Test
    void buy() {
        int amount = 15000;

        assertThat(LottoVendingMachine.calculate(amount))
                .isEqualTo(15);
    }
}
