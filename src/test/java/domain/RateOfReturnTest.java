package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateOfReturnTest {

    @Test
    @DisplayName("수익률을 정상적으로 생성한다.")
    void createSuccess() {
        /* given */

        /* when & then */
        assertDoesNotThrow(() -> new RateOfReturn(10_000L, 20_000L));
    }

    @Test
    @DisplayName("수익이 음수이면 IllegalArgumentException을 던진다.")
    void createFailureNegativeProfit() {
        /* given */

        /* when & then */
        assertThrows(IllegalArgumentException.class, () -> new RateOfReturn(-1_000L, 10_000L));
    }

    @Test
    @DisplayName("투입금액이 0 이하이면 IllegalArgumentException을 던진다.")
    void createFailureNonPositiveInvestment() {
        /* given */

        /* when & then */
        assertThrows(IllegalArgumentException.class, () -> new RateOfReturn(10_000L, 0L));
        assertThrows(IllegalArgumentException.class, () -> new RateOfReturn(10_000L, -1_000L));
    }
}
