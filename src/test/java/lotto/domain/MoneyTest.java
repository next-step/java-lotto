package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {
    @Test
    @DisplayName("구입금액은 0보다 작을 수 없다.")
    void moneyShouldGreaterThanZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> new Money(-1000L));
    }
}
