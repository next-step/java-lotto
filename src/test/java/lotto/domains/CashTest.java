package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CashTest {
    @Test
    void 현재금액으로_구입가능한_수량구하기_테스트() {
        Cash cash = new Cash(14000);
        assertThat(cash.numberOfPurchasesAvailable()).isEqualTo(14);
    }

    @Test
    void 금액이_1000보다_작을경우_에러_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Cash(-1000));
        assertThrows(IllegalArgumentException.class, () -> new Cash(999));
    }
}
