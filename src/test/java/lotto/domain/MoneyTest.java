package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {
    @Test
    @DisplayName("0 이상의 금액은 생성 가능하다.")
    void newMoneyTest() {
        assertDoesNotThrow(() -> {
            new Money(0);
        });
    }

    @Test
    @DisplayName("금액은 0보다 작을 수 없다.")
    void moneyShouldGreaterThanZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> new Money(-1));
    }
}
